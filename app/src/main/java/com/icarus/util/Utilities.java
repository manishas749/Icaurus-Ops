package com.icarus.util;

import com.google.gson.Gson;

import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseFragment;
import com.icarus.constants.Constants;
import com.icarus.customviews.CustomImageSpan;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.UserItems;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Utilities {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static Utilities utilityInstance;

    /*
     *
     * Default Constructor
     */
    private Utilities() {

    }

    /**
     * create single instance of the Utility class. Check if the instance is
     * null then it will create new instance else
     *
     * @param ctx of the activity
     * @return instance
     */
    public static Utilities getInstance(Context ctx) {
        if (utilityInstance == null) {
            utilityInstance = new Utilities();
        }
        return utilityInstance;
    }

    public static String SHA256(String text, int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String resultStr;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes("UTF-8"));
        byte[] digest = md.digest();
        StringBuffer result = new StringBuffer();
        for (byte b : digest) {
            result.append(String.format("%02x", b)); //convert to hex
        }
        if (length > result.toString().length()) {
            resultStr = result.toString();
        } else {
            resultStr = result.toString().substring(0, length);
        }
        return resultStr;
    }


    public static boolean isOnline(Context activity) {
        ConnectivityManager conMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (conMgr != null) {
            networkInfo = conMgr.getActiveNetworkInfo();
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * This method is used to show Toast message with custom message and the
     * custom duration. It will show the toast if
     *
     * @param message  not equal to null
     * @param duration in milliseconds greater than zero else it will show the toast
     *                 with default Toast duration.
     */
    public void showToast(String message, int duration, Context context) {
        if (!TextUtils.isEmpty(message) && !TextUtils.equals("null", message)) {
            try {
                if (duration < 0) {
                    Toast.makeText(context.getApplicationContext(), message,
                            duration).show();
                } else {
                    Toast.makeText(context.getApplicationContext(), message,
                            Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showLog(Type type, String TAG, String message) {
        try {
            if (type != null && (BuildConfig.FLAVOR.equals("development"))) {
                switch (type) {
                    case DEBUG:
                        Log.d(TAG, message);
                        break;
                    case VERBOSE:
                        Log.v(TAG, message);
                        break;

                    case ERROR:
                        Log.e(TAG, message);
                        break;

                    case INFO:
                        Log.i(TAG, message);
                        break;

                    case WARN:
                        Log.w(TAG, message);
                        break;
                    default:
                        Log.e(TAG, message);
                        break;
                }
            } else {
                Log.e(TAG, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to check the connectivity of the selected network
     * type.
     *
     * @param networkType
     * @return true if selected network is connected else return false.
     */
    public boolean checkInternetConnection(NetworkType networkType, Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        switch (networkType) {
            case WIFI:
                for (NetworkInfo ni : netInfo) {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected())
                            return true;
                }

            case MOBILE:
                for (NetworkInfo ni : netInfo) {
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected())
                            return true;
                }
            default:
                return false;
        }
    }

    /**
     * This method is used to show and hide the keyboard
     *
     * @param isShow if true show keyboard else hide.
     */
    public void showHideKeyboard(boolean isShow, Context context) {
        try {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (isShow) {
                imm.showSoftInput(((Activity) context).getCurrentFocus(),
                        InputMethodManager.SHOW_FORCED);
            } else {
                if (imm.isAcceptingText()) {
                    try {
                        imm.hideSoftInputFromWindow(((Activity) context)
                                .getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the current version of the Application
     *
     * @return
     */
    public int getAppVersion() {
        String versionName = com.icarus.BuildConfig.VERSION_NAME;
        int versionCode = com.icarus.BuildConfig.VERSION_CODE;
        return versionCode;
    }

    /**
     * This method is used to replaceFragment with another fragment
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void replaceFragment(int replaceId, Fragment fragment,
                                      String tag, boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public final void replaceFragmentWithAnim(int replaceId, Fragment fragment,
                                              String tag, boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();

        ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        ft.commit();
    }

    public final void replaceFragmentWithAnimPrevious(int replaceId, Fragment fragment,
                                                      String tag, boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();

        ft.setCustomAnimations(R.anim.slide_in_down, R.anim.slide_out_down);
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        ft.commit();
    }


    /**
     * This method is used to replaceFragment with another fragment
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void replaceChildFragment(int replaceId, Fragment fragment,
                                           String tag, boolean isBackStack, Fragment activityContext) {
        FragmentTransaction ft = activityContext.getChildFragmentManager().beginTransaction();
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    /**
     * This method is used to replaceFragment with another fragment
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void replaceChildFragmentWithAnim(int replaceId, Fragment fragment,
                                                   String tag, boolean isBackStack, Fragment activityContext, int leftAnim, int rightAnim) {
        FragmentTransaction ft = activityContext.getChildFragmentManager().beginTransaction();
        ft.setCustomAnimations(leftAnim, rightAnim);
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    /**
     * This method is used to addFragment for the first time
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void addFragment(int replaceId, Fragment fragment, String tag,
                                  boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.add(replaceId, fragment, tag);
        } else {
            ft.add(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    /**
     * This method is used to addFragment for the first time
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void addFragmentWithoutAnimation(int replaceId, Fragment fragment, String tag,
                                                  boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.add(replaceId, fragment, tag);
        } else {
            ft.add(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public final void replaceFragmentWithSlideLeftToRightAnim(int replaceId, Fragment fragment,
                                                              String tag, boolean isBackStack, Context activityContext) {
        FragmentTransaction ft = ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().beginTransaction();

        ft.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_left);
        if (!checkIfStringIsNullOrEmpty(tag)) {
            ft.add(replaceId, fragment, tag);
        } else {
            ft.add(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        } else {
            ft.addToBackStack(null);
        }
        ((AppCompatActivity) activityContext)
                .getSupportFragmentManager().popBackStackImmediate();
        ft.commit();
    }

    /**
     * This method is used to popFragment from stack
     */
    public final void popFragment(int replaceId, final Context activityContext) {
        try {
            FragmentManager fragmentManager = ((AppCompatActivity) activityContext).getSupportFragmentManager();
            if (fragmentManager
                    .getBackStackEntryCount() > 0) {
                FragmentTransaction fragTrans = fragmentManager.beginTransaction();
                fragTrans.remove(fragmentManager.findFragmentById(replaceId));
                fragTrans.commit();
                fragmentManager.popBackStackImmediate();
            } else {
                /*showDoubleOption_AlertDialog(null, "Do you really want to exit from the app.", "Yes", "No", 0, new OnAlertDialogFragmentListener() {
                    @Override
                    public void onPositiveButtonClick(int id) {
                        ((AppCompatActivity) activityContext).finish();
                    }

                    @Override
                    public void onNegativeButtonClick(int id) {

                    }

                    @Override
                    public void onNeutralizeButtonClick(int id) {

                    }

                    @Override
                    public void interfaceAttachError(int fragmentId, String errorResponse) {

                    }

                    @Override
                    public void onBackPress(int id) {

                    }
                }, 101);*/
                // if (((Activity) activityContext) instanceof
                // CommonHomeScreenActivity) {
                // BaseActivityClass.isRunning = false;
                // }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to popFragment from stack
     */
    public final void popChildFragment(int replaceId, final Fragment fragmentContext) {
        try {
            if (((BaseFragment) fragmentContext).getChildFragmentManager()
                    .getBackStackEntryCount() > 0) {
//                FragmentTransaction fragTrans = ((BaseFragment) fragmentContext)
//                        .getSupportFragmentManager().beginTransaction();
//                fragTrans.remove(((BaseFragment) fragmentContext)
//                        .getSupportFragmentManager().findFragmentById(replaceId));
//                fragTrans.commit();
                ((BaseFragment) fragmentContext).getChildFragmentManager()
                        .popBackStackImmediate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to clear all the fragments from stack
     */
    public final void clearBackStack(Context activityContext) {
        try {

            FragmentManager fm = ((AppCompatActivity) activityContext)
                    .getSupportFragmentManager();
            for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                String fragTag = fm.getBackStackEntryAt(i).getName();
                Fragment fragment = fm.findFragmentByTag(fragTag);
                FragmentTransaction fragTrans = ((AppCompatActivity) activityContext)
                        .getSupportFragmentManager().beginTransaction();
                fragTrans.remove(fragment);
                fragTrans.commit();
                fm.popBackStack();

            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to clear all the fragments from stack
     */
    public final void popBackStack(Context activityContext, String tag) {
        try {

            FragmentManager fm = ((AppCompatActivity) activityContext).getSupportFragmentManager();

            fm.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfStringIsNullOrEmpty(String value) {
        boolean isnullorEmpty = false;
        if (TextUtils.equals(value, null)) {
            isnullorEmpty = true;
        } else if (TextUtils.equals(value, "")) {
            isnullorEmpty = true;
        } else if (TextUtils.equals(value, "null")) {
            isnullorEmpty = true;
        } else if (TextUtils.equals(value, "[]")) {
            isnullorEmpty = true;
        } else if (TextUtils.equals(value, " ")) {
            isnullorEmpty = true;
        } else if (TextUtils.equals(value, "{}")) {
            isnullorEmpty = true;
        }

        return isnullorEmpty;
    }


    public String convert24hrTo12hr(int hour, int minute) {

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 00);
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
        String convert = displayFormat.format(cal.getTime());
        return convert;

    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean isEmailValid(final String hex) {
        return hex != null && Pattern.compile(EMAIL_PATTERN).matcher(hex).matches();

    }

    public boolean isValidUrl(String url) {

        boolean isValid = false;
        try {
            URL newUrl = new URL(url);
            isValid = true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return isValid;

    }

    /**
     * **************************************************************************
     * Checks whether the given mobile number is valid.
     *
     * @param mobile represents the mobile number.
     * @return true if the mobile number is valid, false otherwise.
     * @since 27-Jan-2015
     * **************************************************************************
     */
    public boolean isValidNumber(String mobile) {
        return mobile != null && Patterns.PHONE.matcher(mobile).matches();
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        }
        return manufacturer + " " + model;
    }

    public void closeKeyboard(View view, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public void showKeyboard(View v, Context context) {
        v.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * Type of Log. Used in ShowLog method to choose the type of log to show.
     *
     * @author siddharth.brahmi
     */
    public enum Type {
        DEBUG, VERBOSE, ERROR, INFO, WARN
    }

    /**
     * Enum class to declare the types of networks used in android. It will be
     * used in checkInternetConnection method to check the connectivity of the
     * selected type
     *
     * @author siddharth.brahmi
     */
    public enum NetworkType {
        WIFI, MOBILE
    }

    /**
     * Underlines textView
     *
     * @param text    : text to be set on text view
     * @param txtView : TextView to be underlined @return string value
     */
    public void setUnderlineText(String text, TextView txtView) {
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        if (txtView != null) txtView.setText(content);
    }

    /**
     * read file from assets folder
     *
     * @param filename : name of the file with extension
     * @return string value
     */
    public String readFromFile(String filename, AssetManager am) {
        String ret = "";
        try {
            InputStream inputStream = am.open(filename);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((bufferedReader.readLine()) != null) {
                    receiveString = bufferedReader.readLine();
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getCommaSeparatedString(boolean[] selection, List<String> names, String defaultValue) {
        StringBuilder stringBuffer = new StringBuilder();
        String text;
        for (int i = 0; i < selection.length; i++) {
            if (selection[i]) {
                stringBuffer.append(names.get(i));
                stringBuffer.append(", ");
            }
        }
        text = stringBuffer.toString();
        return text.length() > 2 ? text.substring(0, text.length() - 2) : (text.isEmpty() ? defaultValue : text);
    }

    public static String getCommaSeparatedUserNames(List<UserItems> names, String defaultValue) {
        StringBuilder stringBuffer = new StringBuilder();
        String text;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).isSelected()) {
                stringBuffer.append(names.get(i).getFullName());
                stringBuffer.append(", ");
            }
        }
        text = stringBuffer.toString();
        return text.length() > 2 ? text.substring(0, text.length() - 2) : (text.isEmpty() ? defaultValue : text);
    }

    public static String getCommaSeparatedUserIds(List<UserItems> names, String defaultValue) {
        StringBuilder stringBuffer = new StringBuilder();
        String text;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).isSelected()) {
                stringBuffer.append(names.get(i).getId());
                stringBuffer.append(", ");
            }
        }
        text = stringBuffer.toString();
        return text.length() > 2 ? text.substring(0, text.length() - 2) : (text.isEmpty() ? defaultValue : text);
    }

    public static Integer getNegativeId(Integer id) {
        if (id == null || id > 0) {
            id = -1;
        } else {
            id = id - 1;
        }
        return id;
    }

    /**
     * get mime type of a file
     *
     * @param url
     * @return
     */
    public String getMimeTypes(String url) {
        String type1;
        if (url != null && url.lastIndexOf(".") != -1) {
            String ext = url.substring(url.lastIndexOf(".") + 1).toLowerCase();
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            type1 = mime.getMimeTypeFromExtension(ext);
        } else {
            type1 = null;
        }
        return type1;
    }

    /**
     * copy file from one location to another
     *
     * @param src
     * @param dst
     */
    public void copy(File src, File dst) {
        try {
            dst.createNewFile();
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);
            String mime_type = getMimeTypes(dst.toString());
            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            md5ForBitmap(buf);
            out.close();
            if (!TextUtils.isEmpty(mime_type) && mime_type.trim().contains("image")) {
                compressImage(dst);
            }
        } catch (Exception e) {
            dst.delete();
            e.printStackTrace();
        }
    }

    /**
     * read MD5 checksum from Byte Array
     *
     * @param bitmapBytes Bytes of a Bitmap
     * @return
     */
    public String md5ForBitmap(byte[] bitmapBytes) {
        String hash = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bitmapBytes);
            byte[] digestedBytes = messageDigest.digest();

            BigInteger intRep = new BigInteger(1, digestedBytes);
            hash = intRep.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * compress high resolution image into low resolution
     *
     * @param filenew
     * @throws Exception
     */
    private void compressImage(File filenew) throws Exception {

        Bitmap bmap = getBitmapImage(filenew.getAbsolutePath(), -1);
        int width = bmap.getWidth();
        int height = bmap.getHeight();
        if (width > height && (width < 1920 || height < 1080)) {
            return;
        } else if (width < height && (height < 1920 || width < 1080)) {
            return;
        }

        int height_To_set = 0;
        int Newwidth = width;
        int Newheight = height;
        if (height > width) {
            if (height - 1920 > width - 1080) {
                height_To_set = 1920;
            } else if (width - 1080 > height - 1920) {
                height_To_set = 1080;
            }
        } else if (width > height) {
            if (width - 1920 > height - 1080) {
                height_To_set = 1920;
            } else if (width - 1080 > height - 1920) {
                height_To_set = 1080;
            }
        }
        if (height_To_set != 0) {
            if (width > height_To_set) {
                Newwidth = height_To_set;
                Newheight = (int) (height_To_set * height / width);
            } else if (height > height_To_set) {
                Newheight = height_To_set;
                Newwidth = (int) (height_To_set * width / height);
            }
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            FileOutputStream fOut = new FileOutputStream(filenew);
            bmap = Bitmap.createScaledBitmap(bmap, Newwidth, Newheight, true);

            String mime_type = getMimeTypes(filenew.getAbsolutePath());
            String extension = "";
            if (mime_type.trim().contains("image")) {
                extension = "." + mime_type.replace("image", "").replace("/", "");
            }
            bmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            fOut.write(bytes.toByteArray());
            fOut.flush();
            fOut.close();
        }
        bmap.recycle();
    }

    /**
     * get bitmap image from sdcard
     *
     * @param ImagePath:  path of an image
     * @param imageWidth: if imageWidth is -1 then original else size of an image
     * @return
     */
    public Bitmap getBitmapImage(String ImagePath, int imageWidth) {
        Bitmap ThumbImage = null;
        try {
            ThumbImage = null;
            if (imageWidth != -1) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(ImagePath, options), imageWidth, imageWidth);
            } else {
                ThumbImage = BitmapFactory.decodeFile(ImagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ThumbImage != null) {
                if (ThumbImage.getHeight() > 8192 || ThumbImage.getWidth() > 8192) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    ThumbImage = BitmapFactory.decodeFile(ImagePath, options);
                    return ThumbImage;
                }
            }
            if (ThumbImage != null) {
                if (ThumbImage.getHeight() > 4096 || ThumbImage.getWidth() > 4096) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    ThumbImage = BitmapFactory.decodeFile(ImagePath, options);
                    return ThumbImage;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ThumbImage;
    }

    /**
     * @param items element list for getting names
     * @return list of names of elements
     */
    public static String[] getChecklistTitleList(List<ChecklistElementItem> items) {
        String[] item = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            ChecklistElementItem obj = items.get(i);
            item[i] = i + 1 + ". " + obj.getSequenceNo();
        }
        return item;
    }

    /**
     * @param targetTextView
     * @param completeString
     * @param partToClick
     * @param clickableAction
     * @return
     */
    public static void createLink(TextView targetTextView, String completeString,
                                  String partToClick, ClickableSpan clickableAction) {
        SpannableString spannableString = new SpannableString(completeString);
        // make sure the String is exist, if it doesn't exist
        // it will throw IndexOutOfBoundException
        int startPosition = completeString.indexOf(partToClick);
        int endPosition = completeString.lastIndexOf(partToClick) + partToClick.length();
        spannableString.setSpan(clickableAction, startPosition, endPosition,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        targetTextView.setText(spannableString);
        targetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static List<String> getSearchSuggestion() {
        //Retrieve the values
        Gson gson = new Gson();
        String jsonText = BaseApplication.getPreferenceManager().getSearchSuggestions();
        return TextUtils.isEmpty(jsonText) ? null : Arrays.asList(gson.fromJson(jsonText, String[].class));
    }

    public static void saveSearchSuggestion(List<String> data) {
        Gson gson = new Gson();
        if (data.size() > 5)
            data = data.subList(0, 5);
        List<String> textList = new ArrayList<String>(data);
        String jsonText = gson.toJson(textList);
        BaseApplication.getPreferenceManager().setSearchSuggestions(jsonText);
    }


    public static void setImageInTextView(Context context, int drawableID, String text, TextView textView) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(" " + text);


        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), drawableID, null);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ssb.setSpan(new CustomImageSpan(drawable), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(ssb, TextView.BufferType.SPANNABLE);
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public void openFile(String name, String contentType, Context ctx) {
        File file = FileUtils.getFileFromName(name, Constants.RESOURCES);
        Uri photoURI = FileProvider.getUriForFile(ctx, BuildConfig.APPLICATION_ID + ".provider", file);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(photoURI, contentType);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            ctx.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setMessage(R.string.file_open_error);
            builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }
}