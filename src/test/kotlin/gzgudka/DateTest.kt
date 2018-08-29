package gzgudka

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class DateTest {

    @get:Rule
    val exception = ExpectedException.none()!!

    @Test
    fun `should extract day, month and year from the valid date`() {
        // given
        val input = "03/01/1989"

        // when
        val date = Date(input)

        // then
        assertThat(date.day(), `is`(3))
        assertThat(date.month(), `is`(1))
        assertThat(date.year(), `is`(1989))
    }

    @Test
    fun `should throw IllegalArgumentException when date is not valid`() {
        // given
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage(endsWith(("is not a valid date (dd/MM/yyy)")))

        val input = "03-01-1989"

        // when
        Date(input)
    }

}