package dev.yasan.helper.android.library

object PersianValidationHelper {

    private const val PHONE_NUMBER_REGEX = "(\\+989|989|09)9?[0-9]{9}"

    /**
     * Checks if the string is a valid Persian phone number.
     *
     * @author Yasan Ghafariyan
     */
    fun isPersianPhoneNumber(string: String): Boolean =
        Regex(PHONE_NUMBER_REGEX).matchEntire(string) != null

    /**
     * Checks if the string is a valid Persian national code.
     *
     * @author Yasan Ghafariyan
     */
    fun isPersianNationalCode(string: String): Boolean {
        if (string.length != 10) return false
        var nationalCode: Long? = string.toLongOrNull() ?: return false
        val arrayNationalCode = ByteArray(10)

        for (i in 0..9) {
            arrayNationalCode[i] = (nationalCode!! % 10).toByte()
            nationalCode /= 10
        }

        var sum = 0
        for (i in 9 downTo 1) sum += arrayNationalCode[i] * (i + 1)
        val temp = sum % 11
        return if (temp < 2) arrayNationalCode[0].toInt() == temp else arrayNationalCode[0].toInt() == 11 - temp
    }

}

/**
 * Checks if the string is a valid Persian phone number.
 *
 * @author Yasan Ghafariyan
 */
fun String.isPersianPhoneNumber() = PersianValidationHelper.isPersianPhoneNumber(this)

/**
 * Checks if the string is a valid Persian national code.
 *
 * @author Yasan Ghafariyan
 */
fun String.isPersianNationalCode() = PersianValidationHelper.isPersianNationalCode(this)