package com.icarus.util;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.icarus.R;

/**
 * Created by anuragpurwar
 */
public final class Navigator {
    private Navigator() {
    }

    public static void launchActivity(Context context, Intent intent) {
        if (intent != null) {
            context.startActivity(intent);
            ((AppCompatActivity) context).overridePendingTransition(R.anim.slide_right_in, R.anim.backslide_right_out);
        }
    }

    public static void launchActivityAndFinishCurrent(Context context, Intent intent) {
        if (intent != null) {
            context.startActivity(intent);
            ((AppCompatActivity) context).overridePendingTransition(R.anim.slide_right_in, R.anim.backslide_right_out);
            ((AppCompatActivity) context).finish();
        }
    }

    public static void launchActivityWithResult(Context context, int requestCode, Intent intent)
    {
        if (intent != null) {
            ((AppCompatActivity) context).startActivityForResult(intent, requestCode);
            ((AppCompatActivity) context).overridePendingTransition(R.anim.slide_right_in, R.anim.backslide_right_out);
        }
    }

    public static void launchActivityWithResult(Fragment fragment, int requestCode, Intent intent) {
        if (intent != null) {
            fragment.startActivityForResult(intent, requestCode);
            fragment.getActivity().overridePendingTransition(R.anim.slide_right_in, R.anim.backslide_right_out);
        }
    }

}
