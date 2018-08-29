package gzgudka

import java.util.regex.Pattern

data class Date(private val date: String) {

    private val dayMonthYear = Pattern.compile("(?<day>\\d{2})\\/(?<month>\\d{2})\\/(?<year>\\d{4})")
            .matcher(date)
            .let {
                if (!it.matches()) throw IllegalArgumentException("$date is not a valid date (dd/MM/yyy)")
                Triple(it.group("day").toInt(), it.group("month").toInt(), it.group("year").toInt())
            }

    fun day() = dayMonthYear.first

    fun month() = dayMonthYear.second

    fun year() = dayMonthYear.third

}