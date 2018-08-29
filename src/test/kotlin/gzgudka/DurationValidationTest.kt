package gzgudka

import org.hamcrest.CoreMatchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class DurationValidationTest(val startDate: Date, val endDate: Date) {

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index}: invalidDates[{0}-{1}]")
        fun data(): Collection<Array<Date>> = listOf(
                arrayOf(Date("31/12/1900"), Date("31/12/2999")),
                arrayOf(Date("31/12/2999"), Date("01/01/3000")),
                arrayOf(Date("01/12/1734"), Date("31/12/2999")),
                arrayOf(Date("31/12/2999"), Date("01/01/3456"))
        )

    }

    @get:Rule
    val exception = ExpectedException.none()!!

    @Test
    fun `should throw IllegalArgumentException when startDate is before not in the range`() {
        // given
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage(`is`("An input date is invalid. Valid dates are between 01/01/1901 and 31/12/2999"))

        // when
        Duration(startDate, endDate).elapsedDays()
    }

}