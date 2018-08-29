package gzgudka

private val DAYS_IN_MONTH = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

class Duration(private val startDate: Date,
               private val endDate: Date) {

    fun elapsedDays(): Int {
        val daysBeforeStartDate = count(startDate.year(), startDate.month(), startDate.day())
        val daysBeforeEndDate = count(endDate.year(), endDate.month(), endDate.day())
        return daysBeforeEndDate - daysBeforeStartDate - 1
    }

    private fun count(year: Int, month: Int, day: Int) = (year * 365) + daysForMonths(month) + day

    private fun daysForMonths(month: Int) = (0 until month).map { DAYS_IN_MONTH[it] }.sum()

}