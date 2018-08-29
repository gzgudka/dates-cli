package gzgudka

import kotlin.math.max
import kotlin.math.min

private val DAYS_IN_MONTH = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

class Duration(private val startDate: Date,
               private val endDate: Date) {

    fun elapsedDays(): Int {
        val daysBeforeStartDate = count(startDate.year(), startDate.month(), startDate.day())
        val daysBeforeEndDate = count(endDate.year(), endDate.month(), endDate.day())
        return (max(daysBeforeStartDate, daysBeforeEndDate) - min(daysBeforeStartDate, daysBeforeEndDate)) - 1
    }

    private fun count(year: Int, month: Int, day: Int) = (year * 365) + countLeapYears(year) + daysForMonths(month) + day

    private fun countLeapYears(year: Int) = (year / 4) - (year / 100) + (year / 400)

    private fun daysForMonths(month: Int) = (0 until month).map { DAYS_IN_MONTH[it] }.sum()

}