package com.icarus.synchronization;

import androidx.work.Constraints;
import androidx.work.NetworkType;

public class Utils {

    public static Constraints constraints;

    public static Constraints getConstraints() {
        if (constraints == null) {
            constraints = new Constraints.Builder()
                    .build();
        }
        return constraints;
    }

    public static String join(String[] possibleValues) {

        String result = "";

        if (possibleValues != null) {
            for (int i = 0; i < possibleValues.length; i++) {
                if (result.length() == 0)
                    result = result + possibleValues[i];
                else
                    result = result + "," + possibleValues[i];
            }
        }
        return result;
    }
}
