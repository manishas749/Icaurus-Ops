package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.databinding.ObservableField;
import androidx.annotation.NonNull;
import android.text.TextUtils;

import com.icarus.R;

/**
 * Created by Monika Rana on 07/04/2020
 */
public class ReasonPopUpViewModel extends AndroidViewModel {
    private ObservableField<String> txtReason = new ObservableField<>();

    public ReasonPopUpViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableField<String> getTxtReason() {
        return txtReason;
    }

    public String validateReason(int validateLength) {
        if (TextUtils.isEmpty(getTxtReason().get()))
            return getApplication().getString(R.string.error_field_required);
        else if (getTxtReason().get().trim().length() < validateLength) {
            return String.format(getApplication().getString(R.string.validate_input_length), String.valueOf(validateLength));
        } else {
            return "";
        }
    }
}
