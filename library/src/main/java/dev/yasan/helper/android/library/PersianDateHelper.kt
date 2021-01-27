package dev.yasan.helper.android.library

import java.util.*

//TODO replace the deprecated Date class usage
class PersianDate(_year: Int? = null, _month: Int? = null, _day: Int? = null) {

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

    override fun toString(): String = "PersianDate[$year/$month/$day]"

    constructor(date: Date) : this(
        date.year,
        date.month,
        date.day
    )

    fun toGeorgianDate(): Date {
        val gDate = DateConverter.jalaliToGregorian(year, month, day)
        return Date(gDate[0], gDate[1], gDate[2])
    }

    fun toDate() = Date(year, month, day)

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
        var jy1: Int = jYear + 1595
        var days: Int =
            -355668 + (365 * jy1) + ((jy1 / 33).toInt() * 8) + (((jy1 % 33) + 3) / 4).toInt() + jDay + (if (jMonth < 7) ((jMonth - 1) * 31) else (((jMonth - 7) * 30) + 186))
        var gy: Int = 400 * (days / 146097).toInt()
        days %= 146097
        if (days > 36524) {
            gy += 100 * (--days / 36524).toInt()
            days %= 36524
            if (days >= 365) days++
        }
        gy += 4 * (days / 1461).toInt()
        days %= 1461
        if (days > 365) {
            gy += ((days - 1) / 365).toInt()
            days = (days - 1) % 365
        }
        var gd: Int = days + 1
        var sal_a: IntArray = intArrayOf(
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