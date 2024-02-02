package com.feylabs.core.helper.date

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

object UtilDate {

    enum class DateFormat(val pattern: String) {
        DATE("yyyy-MM-dd"),
        DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        TIME("HH:mm:ss"),
        DAY_MONTH_YEAR("dd/MM/yyyy"),
        MONTH_DAY_YEAR("MM/dd/yyyy"),
        DAY_MONTH_YEAR_TIME("dd/MM/yyyy HH:mm:ss"),
        MONTH_DAY_YEAR_TIME("MM/dd/yyyy HH:mm:ss")
    }

    fun getCurrentDateTime(format: DateFormat): String {
        val sdf = SimpleDateFormat(format.pattern, Locale.getDefault())
        return sdf.format(Date())
    }

    fun getDateFromString(dateString: String, format: DateFormat): Date? {
        val sdf = SimpleDateFormat(format.pattern, Locale.getDefault())
        return try {
            sdf.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    fun formatDate(date: Date, format: DateFormat): String {
        val sdf = SimpleDateFormat(format.pattern, Locale.getDefault())
        return sdf.format(date)
    }

    fun isDateAfter(date1: Date, date2: Date): Boolean {
        return date1.after(date2)
    }

    fun isDateBefore(date1: Date, date2: Date): Boolean {
        return date1.before(date2)
    }

    fun getDaysBetweenDates(startDate: Date, endDate: Date): Int {
        val diff = endDate.time - startDate.time
        return (diff / (24 * 60 * 60 * 1000)).toInt()
    }

    fun String.convertIsoDateStringToDate(): Date? {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return try {
            sdf.parse(this)
        } catch (e: Exception) {
            Timber.d("error tanggalan ${e.toString()}")
            return null
        }
    }

    fun String.convertIsoDateStringToIndonesianDateString(): String {
        try {
            val date = this.convertIsoDateStringToDate() ?: return this
            val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            return sdf.format(date ?: Date())
        } catch (e: Exception) {
            return this
        }
    }


}