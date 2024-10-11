package com.icarus.util;

import com.icarus.R;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import c.anurag.database.application.BaseApplication;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class Storage {
    private final Context context;

    public Storage(Context context) {
        this.context = context;
    }

    public File getStoragePath() {
        String external = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/." + context.getResources().getString(R.string.app_name);

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
            e.printStackTrace();
        }
        return exterNalFile;
    }
}
