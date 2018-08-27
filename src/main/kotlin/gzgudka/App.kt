package gzgudka

fun main(args: Array<String>) {
    val startDate = args[0]
    val endDate = args[1]
    println((Duration(Date(startDate), Date(endDate)).elapsedDays()))
}