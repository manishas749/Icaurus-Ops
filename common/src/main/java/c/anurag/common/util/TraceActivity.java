package c.anurag.common.util;

/**
 * TraceActivity
 * This class print the logs for this project. with the help of this class
 * we will close all the logs by single comment TraceActivity.writeActivity(activity)in
 * writeActivity(String activity ) function.
 *
 * @author Anurag Purwar
 * anuragpurwar@gmail.com
 */

import android.util.Log;

import java.util.Calendar;

import c.anurag.common.BuildConfig;

public class TraceActivity {
    /**
     * @Param : Trace -it takes the input which needs to be print
     */
    public static void writeActivity(String activity) {
        //--- get the current date and time
        Calendar m_cal = Calendar.getInstance();
        String str = "[" + m_cal.get(Calendar.MONTH) + "/" + m_cal.get(Calendar.DAY_OF_MONTH) + "/" + m_cal.get(Calendar.YEAR) + " " +
                m_cal.get(Calendar.HOUR_OF_DAY) + ":" + m_cal.get(Calendar.MINUTE) + ":" + m_cal.get(Calendar.SECOND) + ":" +
                m_cal.get(Calendar.MILLISECOND) + "]";
        // --- display the activity
        if (BuildConfig.DEBUG) {
            Log.d(str, activity);
        }
    }

    public static void writeActivity(String tag, String activity) {
        //--- get the current date and time
        Calendar m_cal = Calendar.getInstance();
        // --- display the activity
        if (BuildConfig.DEBUG) {
            Log.d(tag, activity);
        }
    }

    public static void writeActivity(int activity) {
        //--- get the current date and time
        Calendar m_cal = Calendar.getInstance();
        String str = "[" + m_cal.get(Calendar.MONTH) + "/" + m_cal.get(Calendar.DAY_OF_MONTH) + "/" + m_cal.get(Calendar.YEAR) + " " +
                m_cal.get(Calendar.HOUR_OF_DAY) + ":" + m_cal.get(Calendar.MINUTE) + ":" + m_cal.get(Calendar.SECOND) + ":" +
                m_cal.get(Calendar.MILLISECOND) + "]";
        // --- display the activity
        if (BuildConfig.DEBUG) {
            Log.d(str, activity + "");
        }
    }

    public static void writeActivityError(String activity) {
        //--- get the current date and time
        Calendar m_cal = Calendar.getInstance();
        String str = "[" + m_cal.get(Calendar.MONTH) + "/" + m_cal.get(Calendar.DAY_OF_MONTH) + "/" + m_cal.get(Calendar.YEAR) + " " +
                m_cal.get(Calendar.HOUR_OF_DAY) + ":" + m_cal.get(Calendar.MINUTE) + ":" + m_cal.get(Calendar.SECOND) + ":" +
                m_cal.get(Calendar.MILLISECOND) + "]";
        // --- display the activity
        if (BuildConfig.DEBUG) {
            Log.e(str, activity);
        }
    }
}
