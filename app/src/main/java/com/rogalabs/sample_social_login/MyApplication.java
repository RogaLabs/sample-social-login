package com.rogalabs.sample_social_login;

import android.app.Application;

import com.rogalabs.lib.LoginApplication;

/**
 * Created by roga on 18/07/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoginApplication.startSocialLogin(this);
    }
}
