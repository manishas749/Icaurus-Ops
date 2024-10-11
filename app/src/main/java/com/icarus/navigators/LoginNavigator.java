package com.icarus.navigators;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public interface LoginNavigator {

    void performLogin();

    void onEmailError(int resID);

    void onPasswordError(int resID);

    void openTCScreen();

    void openDashBoardScreen();

    void openForgotPassword();

    void onValidateLoginSuccess();

    void noInternet();
}
