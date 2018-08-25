package gzgudka

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class DurationTest(val startDate: String, val endDate: String, val daysElapsed: Int) {

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index}: durationBetween[{0}-{1}]={2}")
        fun data(): Collection<Array<Any>> = listOf(
                arrayOf("07/11/1972", "08/11/1972", 0),
                arrayOf("01/01/2000", "03/01/2000", 1),
                arrayOf("02/06/1983", "22/06/1983", 19),
                arrayOf("04/07/1984", "25/12/1984", 173),
                arrayOf("03/01/1989", "03/08/1983", 1979)
        )

    }

    @Test()
    fun test() {
        // when
        val daysCount = Duration(startDate, endDate).elapsedDays()

        // then
        assertThat(daysCount, `is`(daysElapsed))
    }

}