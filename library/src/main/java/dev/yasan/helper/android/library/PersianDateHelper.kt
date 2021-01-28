package dev.yasan.helper.android.library

import java.util.*

//TODO replace the deprecated Date class usage
class PersianDate(_year: Int? = null, _month: Int? = null, _day: Int? = null) {

    enum class DAY(name: String) {
        SUNDAY("یکشنبه"),
        MONDAY("دوشنبه"),
        TUESDAY("سه شنبه"),
        WEDNESDAY("چهارشنبه"),
        THURSDAY("پنجشنبه"),
        FRIDAY("جمعه"),
        SATURDAY("شنبه")
    }

    var year: Int
    var month: Int
    var day: Int

    init {
        if (_year == null || _month == null || _day == null) {
            val gDate = Date()
            val jDate = DateConverter.gregorianToJalali(
                gDate.year,
                gDate.month,
                gDate.day
            )
            year = _year ?: jDate[0]
            month = _month ?: jDate[1]
            day = _day ?: jDate[2]
        } else {
            year = _year
            month = _month
            day = _day
        }
    }

    constructor(date: Date) : this(0, 0, 0) {
        val persianDateIntArray = DateConverter.gregorianToJalali(date.year, date.month, date.day)
        year = persianDateIntArray[0]
        month = persianDateIntArray[1]
        day = persianDateIntArray[2]
    }

    override fun toString(): String = "PersianDate[y$year/m$month/d$day]"

    fun toGeorgianDate(): Date {
        val gDate = DateConverter.jalaliToGregorian(year, month, day)
        return Date(gDate[0], gDate[1], gDate[2])
    }

    companion object {

        fun getCurrentPersianDayName(): String =
            dayOfWeekToPersianName(Calendar.getInstance()[Calendar.DAY_OF_WEEK])

        fun dayOfWeekToPersianName(day: Int): String {
            return when (day) {
                Calendar.SUNDAY -> DAY.SUNDAY.name
                Calendar.MONDAY -> DAY.MONDAY.name
                Calendar.TUESDAY -> DAY.TUESDAY.name
                Calendar.WEDNESDAY -> DAY.WEDNESDAY.name
                Calendar.THURSDAY -> DAY.THURSDAY.name
                Calendar.FRIDAY -> DAY.FRIDAY.name
                else -> DAY.SATURDAY.name
            }
        }

    }

}

fun Date.toPersian() = PersianDate(this)

private object DateConverter {

    /**  Gregorian & Jalali (Hijri_Shamsi,Solar) Date Converter Functions
    Author: JDF.SCR.IR =>> Download Full Version :  http://jdf.scr.ir/jdf
    License: GNU/LGPL _ Open Source & Free :: Version: 2.80 : [2020=1399]
    ---------------------------------------------------------------------
    355746=361590-5844 & 361590=(30*33*365)+(30*8) & 5844=(16*365)+(16/4)
    355666=355746-79-1 & 355668=355746-79+1 &  1595=605+990 &  605=621-16
    990=30*33 & 12053=(365*33)+(32/4) & 36524=(365*100)+(100/4)-(100/100)
    1461=(365*4)+(4/4) & 146097=(365*400)+(400/4)-(400/100)+(400/400)  */

    fun gregorianToJalali(gYear: Int, gMonth: Int, gDay: Int): IntArray {
        val g_d_m: IntArray = intArrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
        val gy2: Int = if (gMonth > 2) (gYear + 1) else gYear
        var days: Int =
            355666 + (365 * gYear) + ((gy2 + 3) / 4) - ((gy2 + 99) / 100) + ((gy2 + 399) / 400) + gDay + g_d_m[gMonth - 1]
        var jYear: Int = -1595 + (33 * (days / 12053))
        days %= 12053
        jYear += 4 * (days / 1461)
        days %= 1461
        if (days > 365) {
            jYear += ((days - 1) / 365)
            days = (days - 1) % 365
        }
        val jMonth: Int;
        val jDay: Int;
        if (days < 186) {
            jMonth = 1 + (days / 31)
            jDay = 1 + (days % 31)
        } else {
            jMonth = 7 + ((days - 186) / 30)
            jDay = 1 + ((days - 186) % 30)
        }
        return intArrayOf(jYear, jMonth, jDay)
    }

    fun jalaliToGregorian(jYear: Int, jMonth: Int, jDay: Int): IntArray {
        val jy1: Int = jYear + 1595
        var days: Int =
            -355668 + (365 * jy1) + ((jy1 / 33) * 8) + (((jy1 % 33) + 3) / 4) + jDay + (if (jMonth < 7) ((jMonth - 1) * 31) else (((jMonth - 7) * 30) + 186))
        var gy: Int = 400 * (days / 146097)
        days %= 146097
        if (days > 36524) {
            gy += 100 * (--days / 36524)
            days %= 36524
            if (days >= 365) days++
        }
        gy += 4 * (days / 1461)
        days %= 1461
        if (days > 365) {
            gy += ((days - 1) / 365)
            days = (days - 1) % 365
        }
        var gd: Int = days + 1
        val sal_a: IntArray = intArrayOf(
            0,
            31,
            if ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) 29 else 28,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31
        )
        var gm: Int = 0
        while (gm < 13 && gd > sal_a[gm]) gd -= sal_a[gm++]
        return intArrayOf(gy, gm, gd)
    }

}