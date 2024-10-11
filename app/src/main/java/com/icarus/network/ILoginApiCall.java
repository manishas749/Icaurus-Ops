package com.icarus.network;

import com.icarus.entities.Login;
import com.icarus.entities.LoginEntity;

import c.anurag.network.callback.IViewCallback;

public abstract class ILoginApiCall {
    public abstract void getLogin(IViewCallback<LoginEntity> abstractViewCallback);




}