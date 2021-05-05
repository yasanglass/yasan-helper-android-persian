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

}

/**
 * Checks if the string is a valid Persian phone number.
 *
 * @author Yasan Ghafariyan
 */
fun String.isPersianPhoneNumber() = PersianValidationHelper.isPersianPhoneNumber(this)