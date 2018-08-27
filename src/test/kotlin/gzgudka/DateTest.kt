package gzgudka

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class DateTest {

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

    @Test(expected = IllegalArgumentException::class)
    fun `should throw IllegalArgumentException when date is not valid`() {
        // given
        val input = "03-01-1989"

        // when
        Date(input)
    }

}