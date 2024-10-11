package c.anurag.database.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import c.anurag.common.R;
import c.anurag.database.application.BaseApplication;

/**
 * @author Anurag Purwar
 */
public class CommonFunctions {

    private final Context context;

    public CommonFunctions(Context context) {
        this.context = context;
    }

    public String getUUID() {
        return String.valueOf(UUID.randomUUID());
    }

    /**
     * Get UTC time
     *
     * @return
     */
    public String getUtcTime() {
        String location_val = BaseApplication.getPreferenceManager().getUserLocationTimeZone();
        //App.getSharedPrefConstant().getSharedPrefString(location);
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        if (!TextUtils.isEmpty(location_val)) {
            inputFormat.setTimeZone(TimeZone.getTimeZone("GMT" + location_val));
        } else {
            inputFormat.setTimeZone(TimeZone.getDefault());
        }

        Date current_date = null;

        try {
            current_date = inputFormat.parse(inputFormat.format(System.currentTimeMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        curFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        return curFormater.format(current_date);
    }

    /**
     * Set default internal storage path for saving resources, logo, attachments etc..
     *
     * @return
     */
    public File getStoragePath() {
        String external = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/." + BaseApplication.getContext().getResources().getString(R.string.app_name);

        File exterNalFile = new File(external);

        if (!exterNalFile.isDirectory()) {
            exterNalFile.delete();
        }

        if (!exterNalFile.exists()) {
            exterNalFile.mkdirs();
        }

        String UUID = BaseApplication.getPreferenceManager().getClientUuid();
        exterNalFile = new File(external, UUID);

        if (!exterNalFile.exists()) {
            exterNalFile.mkdirs();
        }

        File NoMediaFile = new File(external, ".nomedia");

        try {
            NoMediaFile.createNewFile();
        } catch (IOException e) {

        }
        return exterNalFile;
    }

    public static void showToast(String message) {
        Toast.makeText(BaseApplication.getContext(), message, Toast.LENGTH_LONG).show();

    }
}