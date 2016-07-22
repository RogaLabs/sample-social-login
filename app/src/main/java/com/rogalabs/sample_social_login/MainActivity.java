package com.rogalabs.sample_social_login;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.rogalabs.lib.Callback;
import com.rogalabs.lib.LoginView;
import com.rogalabs.lib.SocialUser;

public class MainActivity extends LoginView {

    private ProfileFragmentDialog profileFragmentDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.google_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithGoogle(new Callback() {
                    @Override
                    public void onSuccess(SocialUser socialUser) {
                        buildProfileDialog(socialUser);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });

        findViewById(R.id.facebook_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithFacebook(new Callback() {
                    @Override
                    public void onSuccess(SocialUser socialUser) {
                        buildProfileDialog(socialUser);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }

    private void buildProfileDialog(SocialUser user){
        profileFragmentDialog = ProfileFragmentDialog.newInstance(user);
        profileFragmentDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
        profileFragmentDialog.show(getSupportFragmentManager(), "dialog");
    }
}
