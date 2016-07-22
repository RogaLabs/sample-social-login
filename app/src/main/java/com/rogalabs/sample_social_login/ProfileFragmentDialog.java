package com.rogalabs.sample_social_login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rogalabs.lib.SocialUser;
import com.squareup.picasso.Picasso;

/**
 * Created by roga on 18/07/16.
 */
public class ProfileFragmentDialog extends DialogFragment {

    private static final String KEY_EXTRA_USER = "social_user";
    private ImageView profileImage;
    private TextView profileId;
    private TextView profileName;
    private TextView profileEmail;


    public static ProfileFragmentDialog newInstance(SocialUser socialUser){
        ProfileFragmentDialog fragmentDialog = new ProfileFragmentDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_EXTRA_USER, socialUser);
        fragmentDialog.setArguments(bundle);
        return fragmentDialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_content, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        SocialUser socialUser = (SocialUser) getArguments().getSerializable(KEY_EXTRA_USER);
        Picasso.with(view.getContext()).load(socialUser.getPhotoUrl()).fit().into(profileImage);
        profileId.setText(String.format("ID : %s",socialUser.getId()));
        profileName.setText(String.format("NAME : %s",socialUser.getName()));
        profileEmail.setText(String.format("EMAIL : %s",socialUser.getEmail()));
    }

    private void initView() {
        profileImage = (ImageView) getView().findViewById(R.id.profile_picture);
        profileId = (TextView) getView().findViewById(R.id.profile_id);
        profileName = (TextView) getView().findViewById(R.id.profile_name);
        profileEmail = (TextView) getView().findViewById(R.id.profile_email);
    }

}
