package com.icarus.util;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.icarus.BuildConfig;
import com.icarus.base.BaseApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private static final String TAG = "MD5";

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();

        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }

        return buf.toString();
    }

    public static String sha1(String text, String salt) {
        String generatedText = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(text.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            generatedText = sb.toString();
        } catch (Exception e) {
            Log.e(TAG, "Exception while calculating password hash", e);
        }

        return generatedText;
    }

    public static boolean checkMD5(String md5, File updateFile) {
        if (TextUtils.isEmpty(md5) || updateFile == null) {
            Log.e(TAG, "MD5 string empty or updateFile null");
            return false;
        }
        try {
            String calculatedDigest = calculateMD5(updateFile);
            if (calculatedDigest == null) {
                Log.e(TAG, "calculatedDigest null");
                return false;
            }
            Log.v(TAG, "Calculated digest: " + calculatedDigest);
            Log.v(TAG, "Provided digest: " + md5);
            return calculatedDigest.equalsIgnoreCase(md5);
        } catch (Exception ex) {
            Log.e(TAG, "Exception while checking MD5", ex);
            return false;
        }
    }

    public static String calculateMD5(File updateFile) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Exception while getting digest", e);
            return null;
        }

        InputStream is;
        try {
            Uri uri = FileProvider.getUriForFile(BaseApplication.getContext(), BuildConfig.APPLICATION_ID + ".provider", updateFile);
            ParcelFileDescriptor parcelFileDescriptor = BaseApplication.getContext()
                    .getContentResolver()
                    .openFileDescriptor(uri, "r", null);
            is = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Exception while getting FileInputStream", e);
            return null;
        }

        byte[] buffer = new byte[8192];
        int read;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            // Fill to 32 chars
            output = String.format("%32s", output).replace(' ', '0');
            return output;
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(TAG, "Exception on closing MD5 input stream", e);
            }
        }
    }

}