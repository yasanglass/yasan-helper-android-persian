package dev.yasan.helper.android.library

object PersianNumberHelper {

    fun convertNumbersToEnglish(string: String): String = string.apply {
        replace("۰", "0")
        replace("۱", "1")
        replace("۲", "2")
        replace("٣", "3")
        replace("٤", "4")
        replace("۵", "5")
        replace("٦", "6")
        replace("٧", "7")
        replace("۸", "8")
        replace("۹", "9")
    }

    fun convertNumbersToPersian(string: String): String = string.apply {
        replace("0", "۰")
        replace("1", "۱")
        replace("2", "۲")
        replace("3", "٣")
        replace("4", "٤")
        replace("5", "۵")
        replace("6", "٦")
        replace("7", "٧")
        replace("8", "۸")
        replace("9", "۹")
    }

}

fun String.toPersian() = PersianNumberHelper.convertNumbersToPersian(this)
fun String.toEnglish() = PersianNumberHelper.convertNumbersToEnglish(this)
