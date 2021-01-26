package dev.yasan.helper.android.library

object PersianHelper {

    fun convertNumbersToEnglish(string: String): String {
        var s = string
        s = s.replace("۰", "0")
        s = s.replace("۱", "1")
        s = s.replace("۲", "2")
        s = s.replace("٣", "3")
        s = s.replace("٤", "4")
        s = s.replace("۵", "5")
        s = s.replace("٦", "6")
        s = s.replace("٧", "7")
        s = s.replace("۸", "8")
        s = s.replace("۹", "9")
        return s
    }

    fun convertNumbersToPersian(string: String): String {
        var s = string
        s = s.replace("0", "۰")
        s = s.replace("1", "۱")
        s = s.replace("2", "۲")
        s = s.replace("3", "٣")
        s = s.replace("4", "٤")
        s = s.replace("5", "۵")
        s = s.replace("6", "٦")
        s = s.replace("7", "٧")
        s = s.replace("8", "۸")
        s = s.replace("9", "۹")
        return s
    }

}

fun String.toPersian() = PersianHelper.convertNumbersToPersian(this)
fun String.toEnglish() = PersianHelper.convertNumbersToEnglish(this)