package com.icarus.util;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import androidx.core.app.NotificationCompat;

import com.icarus.R;
import com.icarus.activities.DashboardActivity;
import com.icarus.activities.LoginActivity;

import java.util.List;

/**
 * Created by Anurag Purwar on 18/6/19.
 */
public class NotificationUtil {

    /**
     * check App is is foreground or backround
     *
     * @return true if app is in foreground else false
     */
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * display notification
     *
     * @param title Title to be display
     */
    public static void displayNotificationOne(String title, Context context) {
        int NOTIFICATION_ID = 234;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String CHANNEL_ID = "my_channel_01";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.icarus_notification_icon)
                .setContentTitle(title)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent;
        if (title.equalsIgnoreCase(context.getString(R.string.unauthorized))) {
            resultIntent = new Intent(context, LoginActivity.class);

        } else {
            resultIntent = new Intent(context, DashboardActivity.class);
            resultIntent.putExtra(DashboardActivity.IS_NOTIFICATION, true);
        }

        //This ensures that navigating backward from the Activity leads out of the app to Home page
        TaskStackBuilder stackBuilder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            stackBuilder = TaskStackBuilder.create(context);


            // Adds the back stack for the Intent
            //stackBuilder.addParentStack(DashBoardActivity.class);

            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT //can only be used once
            );

            // start the activity when the user clicks the notification text
            builder.setContentIntent(resultPendingIntent);
        }
        NotificationManager myNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // pass the Notification object to the system
        myNotificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
