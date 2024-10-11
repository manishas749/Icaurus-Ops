package com.icarus.util

import android.text.TextUtils

/**
 * Created by Anurag Purwar on 14/9/2018.
 */

object StringUtil {

    fun toTitleCase(modelDisplay: String?): String? {

        if (modelDisplay == null) {
            return null
        }

        var space = true
        val builder = StringBuilder(modelDisplay)
        val len = builder.length

        for (i in 0 until len) {
            val c = builder[i]
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c))
                    space = false
                }
            } else if (Character.isWhitespace(c)) {
                space = true
            } else {
                builder.setCharAt(i, Character.toLowerCase(c))
            }
        }

        return builder.toString()
    }

    fun toCamelCase(inputString: String): String {
        var result = ""
        if (TextUtils.isEmpty(inputString)) {
            return result
        }
        val stringBuilder = StringBuilder()
        for (str in inputString.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (str.length > 1) {
                stringBuilder.append(str.substring(0, 1).uppercase() + str.substring(1).lowercase()).append(" ")
            } else {
                stringBuilder.append(str.uppercase())
            }
        }
        result = stringBuilder.toString().trim { it <= ' ' }
        return result
    }

    fun listNotNull(list: MutableList<*>?): Boolean {
        if (list != null && !list.isEmpty()) {
            list.removeAll(setOf<Any>())
            return true
        }

        return false
    }

    fun hasIndex(index: Int, list: List<*>?): Boolean {
        return list != null && index > -1 && index < list.size
    }

    fun isArrayNotEmpty(arr: IntArray?): Boolean {
        return arr != null && arr.size != 0
    }

    fun isArrayNotEmpty(arr: Array<String>?): Boolean {
        return arr != null && arr.size != 0
    }

    /**
     * method to check if given string is null or empty.
     *
     * @param stringToCheck
     * string to check if it is null or empty.
     *
     * @return if given string is null or empty it will return default string else the given string itself.
     */
    fun getCheckedString(stringToCheck: String): String {
        return if (!TextUtils.isEmpty(stringToCheck)) stringToCheck else ""
    }
}
