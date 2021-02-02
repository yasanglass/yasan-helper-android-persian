package dev.yasan.helper.android.library

/**
 * A helper class with a set of functions that help with numeric difficulties in Persian Android applications.
 * @author Yasan Ghafariyan
 */
object PersianNumberHelper {

    /**
     * Converts all the Persian numeric characters in the String into the English ones.
     * @param string any string that contains English numeric characters
     * @return the converted String
     * @author Yasan Ghafariyan
     */
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

    /**
     * Converts all the English numeric characters in the String into the Persian ones.
     * @param string any string that contains Persian numeric characters
     * @return the converted String
     * @author Yasan Ghafariyan
     */
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

/**
 * Converts all the English numeric characters in the String into the Persian ones.
 * @return the converted String
 * @author Yasan Ghafariyan
 */
fun String.toPersian() = PersianNumberHelper.convertNumbersToPersian(this)

/**
 * Converts all the Persian numeric characters in the String into the English ones.
 * @return the converted String
 * @author Yasan Ghafariyan
 */
fun String.toEnglish() = PersianNumberHelper.convertNumbersToEnglish(this)

/**
 * Converts the Int into a String with Persian numeric characters.
 * @return the converted String
 * @see String.toPersian
 * @author Yasan Ghafariyan
 */
fun Int.toStringPersian() = PersianNumberHelper.convertNumbersToPersian(this.toString())
