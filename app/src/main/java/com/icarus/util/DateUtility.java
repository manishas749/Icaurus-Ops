package com.icarus.util;

import com.icarus.base.BaseApplication;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtility {

    //2019-01-17 12:37:48

    /**
     * Date formating yyyy-MM-dd HH:mm:ss to hh:mm am if today, dd MMM date if current year else dd mmm, yyyy if
     *
     * @param date
     * @return
     */
    public static String showFormattedDate(String date) {
        if (date == null || TextUtils.isEmpty(date))
            return "";
        String finalDate = "";
        String locationTimeZone = BaseApplication.getPreferenceManager().getUserLocationTimeZone();
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.getDefault());
        Date formattedDate = null;
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar calendar = Calendar.getInstance();

        try {
            formattedDate = inputFormat.parse(date);
            calendar.setTime(formattedDate);
            //Check date and format
            if (formattedDate.equals(inputFormat.parse(AppUtility.Companion.getUtcTime()))) {
                finalDate = formatDate(locationTimeZone, "hh:mm aa").format(formattedDate).toLowerCase();
            } else if (calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
                finalDate = formatDate(locationTimeZone, "d MMM").format(formattedDate);
            } else
                finalDate = formatDate(locationTimeZone, "d MMM, yyyy").format(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return finalDate;
    }

    private static SimpleDateFormat formatDate(String locationTimeZone, String outputPattern) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());
        if (!TextUtils.isEmpty(locationTimeZone)) {
            dateTimeFormat.setTimeZone(TimeZone.getTimeZone(locationTimeZone));
        } else {
            dateTimeFormat.setTimeZone(TimeZone.getDefault());
        }
        return dateTimeFormat;
    }

    public static Date getDateFromString(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return format.parse(dateString);
        } catch (Exception e) {
            Log.e("DateUtility", e.getMessage());

            return new Date();
        }
    }

    public static String getElapsedTime(long ms) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long days = ms / daysInMilli;
        ms = ms % daysInMilli;

        long hours = ms / hoursInMilli;
        ms = ms % hoursInMilli;

        long minutes = ms / minutesInMilli;
        ms = ms % minutesInMilli;

        long seconds = ms / secondsInMilli;

        if (seconds == 0)
            return "N/A";
        if (minutes == 0)
            return String.format(Locale.getDefault(), "%02ds", seconds);
        if (hours == 0)
            return String.format(Locale.getDefault(), "%02dm %02ds", minutes, seconds);
        if (days == 0)
            return String.format(Locale.getDefault(), "%02dh %02dm %02ds", hours, minutes, seconds);
        return String.format(Locale.getDefault(), "%02dd %02dh %02dm %02ds", days, hours, minutes, seconds);
    }

    public static boolean isLatestData(String dateFromServer, String dateExistLocally) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dateServer = sdf.parse(dateFromServer);
            dateExistLocally = dateExistLocally.replace(".000000", "");

            Date dateExist = sdf.parse(dateExistLocally);
            return dateServer.after(dateExist);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
