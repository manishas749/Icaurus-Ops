package com.icarus.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import c.anurag.database.application.BaseApplication
import com.icarus.models.RoomAssetItems
import com.icarus.models.UserItems
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.zone.ZoneRulesException
import java.util.*


class AppUtility {
    companion object {
        @SuppressLint("NewApi")
        fun setBackgroundDrawable(context: Context, view: View, color: Int) {
            view.background = ContextCompat.getDrawable(context, color)
        }

        fun setTextColor(context: Context, view: TextView, color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.setTextColor(context.getColor(color))
            } else {
                view.setTextColor(ContextCompat.getColor(context, color))
            }
        }

        @SuppressLint("SimpleDateFormat")
        fun getUtcTime(): String {
            val inputPattern = "yyyy-MM-dd HH:mm:ss"
            val inputFormat = SimpleDateFormat(inputPattern)
            var current_date: Date? = null
            try {
                current_date = inputFormat.parse(inputFormat.format(System.currentTimeMillis()))
            } catch (e: ParseException) {
                e.printStackTrace()
            }


            val curFormater = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            curFormater.timeZone = TimeZone.getTimeZone("UTC")
            return curFormater.format(current_date)
        }

        @SuppressLint("SimpleDateFormat")
        fun getUtcTimeImageFileName(): String {
            val inputPattern = "yyyyMMdd_HHmmss"
            val inputFormat = SimpleDateFormat(inputPattern)
            var currentDate: Date? = null
            try {
                currentDate = inputFormat.parse(inputFormat.format(System.currentTimeMillis()))
            } catch (e: ParseException) {
                e.printStackTrace()
            }


            val curFormater = SimpleDateFormat("yyyyMMdd_HHmmss")
            curFormater.timeZone = TimeZone.getTimeZone("UTC")
            return "IMG_" + curFormater.format(currentDate) + ".jpg"
        }

        @SuppressLint("SimpleDateFormat")
        fun getYMDTime(): String {
            val inputPattern = "yyyyMMdd"
            val inputFormat = SimpleDateFormat(inputPattern)
            var current_date: Date? = null
            try {
                current_date = inputFormat.parse(inputFormat.format(System.currentTimeMillis()))
            } catch (e: ParseException) {
                e.printStackTrace()
            }


            val curFormater = SimpleDateFormat("yyyyMMdd")
            curFormater.timeZone = TimeZone.getTimeZone("UTC")
            return curFormater.format(current_date)
        }


        fun compairTwoDates(currentTime: String, previousTime: String): Boolean {
            if (TextUtils.isEmpty(previousTime)) {
                return false;
            }
            var dateexist = previousTime
            var check = false
            val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            val currentDateTime = sdf.parse(currentTime)
            dateexist = dateexist.replace(".000000", "")

            val previousDateTime = sdf.parse(dateexist)
            check = currentDateTime.after(previousDateTime)
            return check
        }

        fun <T> getTitleList(items: List<T>): List<String> {
            val item: ArrayList<String> = ArrayList()
            for (i in 0 until items.size) {
                val obj = items.get(i)
                if (obj is UserItems) {
                    item.add(obj.fullName!!)
                } else if (obj is RoomAssetItems) {
                    item.add(obj.roomAsset)
                }
            }
            return item
        }

        fun getUuid(): String {
            return UUID.randomUUID().toString()
        }

        fun formatDueDate(time: String): String {
            //Get the time zone of selected location by user
            val timeZone = BaseApplication.getPreferenceManager().userLocationTimeZone
            var timeZoneID = ZoneId.systemDefault()

            //Gets time zone id of selected location,
            //If selected time zone is empty use system default time zone
            //Throw exception in case of exception while getting time zone
            try {
                if (!TextUtils.isEmpty(timeZone)) {
                    timeZoneID = ZoneId.of(timeZone)
                }
            } catch (ex: ZoneRulesException) {
                ex.printStackTrace()
                throw DateTimeException("Invalid DateTime")
            } catch (ex: DateTimeException) {
                ex.printStackTrace()
                throw DateTimeException("Invalid DateTime")
            }

            //Input date time format of selected date
            val inputPattern = "dd MMM, yyyy HH:mm:ss"
            //Expected date format which will be saved in database
            val outputPattern = "yyyy-MM-dd HH:mm:ss"

            val inputFormatter = DateTimeFormatter.ofPattern(inputPattern)
            val outputFormatter = DateTimeFormatter.ofPattern(outputPattern)
            //throws DateTimeParseException if the selected time cannot be parsed
            try {
                val selectedDateTime = LocalDateTime.parse(time, inputFormatter)
                //Parse the selected time with the location time zone id
                // Zone id (e.g. "Australia/Sydney", "Asia/kolkata")
                val locationDateTime = ZonedDateTime.of(selectedDateTime, timeZoneID)
                //returns the selected location time converted to UTC time
                return locationDateTime.withZoneSameInstant(ZoneOffset.UTC).format(outputFormatter)
            } catch (ex: DateTimeParseException) {
                throw DateTimeException("Invalid DateTime")
            }
        }

        /**
         * Date formating yyyy-MM-dd HH:mm:ss to dd MMM, yyyy HH:mm:ss
         *
         * @param time
         *
         * @return
         */
        @SuppressLint("SimpleDateFormat")
        fun parseDateToddMMyyyy(time: String): String {
            val location_val = BaseApplication.getPreferenceManager().userLocationTimeZone

            val inputPattern = "yyyy-MM-dd HH:mm:ss"
            val inputFormat = SimpleDateFormat(inputPattern)
            val dateTimeFormat = SimpleDateFormat("dd MMM, yyyy HH:mm:ss")
            var date: Date? = null
            var str = ""
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            try {
                date = inputFormat.parse(time)
                if (!TextUtils.isEmpty(location_val)) {
                    dateTimeFormat.timeZone = TimeZone.getTimeZone(location_val)
                } else {
                    dateTimeFormat.timeZone = TimeZone.getDefault()
                }
                str = dateTimeFormat.format(date)
            } catch (e: Exception) {
                str = time;
            }

            return str
        }


        /**
         * Date formating yyyy-MM-dd HH:mm:ss to dd MMM, yyyy HH:mm:ss
         *
         * @param time
         *
         * @return
         */
        @SuppressLint("SimpleDateFormat")
        fun parseDateToddMMMyyyy(time: String): String {
            val location_val = BaseApplication.getPreferenceManager().userLocationTimeZone

            val inputPattern = "yyyy-MM-dd HH:mm:ss"
            val inputFormat = SimpleDateFormat(inputPattern)
            val dateTimeFormat = SimpleDateFormat("dd MMMM, yyyy HH:mm:ss")
            var date: Date? = null
            var str = ""
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            try {
                date = inputFormat.parse(time)
                if (!TextUtils.isEmpty(location_val)) {
                    dateTimeFormat.timeZone = TimeZone.getTimeZone(location_val)
                } else {
                    dateTimeFormat.timeZone = TimeZone.getDefault()
                }
                str = dateTimeFormat.format(date)
            } catch (e: Exception) {
                str = time;
            }

            return str
        }
    }
}
