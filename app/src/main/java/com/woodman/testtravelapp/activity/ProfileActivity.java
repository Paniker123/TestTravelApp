package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.dialog.HelpInfoDialog;
import com.woodman.testtravelapp.dialog.NotificationDialog;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewProfileAvatar;
    private TextView textViewUserName;
    private LinearLayout layoutSocialNetwork;
    private LinearLayout layoutTravelGuide;
    private LinearLayout layoutNotification;
    private LinearLayout layoutHelp;
    private LinearLayout layoutFeedback;
    private ImageButton btnEditProfile;
    private ImageButton btnSingOut;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageViewProfileAvatar = findViewById(R.id.image_view_profile_avatar);
        textViewUserName = findViewById(R.id.text_view_user_name_profile_activity);

        layoutSocialNetwork = findViewById(R.id.layout_social_network);
        layoutTravelGuide = findViewById(R.id.layout_travel_guide);
        layoutNotification = findViewById(R.id.layout_notification);
        layoutHelp = findViewById(R.id.layout_help);
        layoutFeedback = findViewById(R.id.layout_feedback);
        btnEditProfile = findViewById(R.id.btn_edit_profile);
        btnSingOut = findViewById(R.id.btn_sing_out);

        mAuth = FirebaseAuth.getInstance();
        getProfileInfo();

        layoutSocialNetwork.setOnClickListener(this);
        layoutTravelGuide.setOnClickListener(this);
        layoutNotification.setOnClickListener(this);
        layoutHelp.setOnClickListener(this);
        layoutFeedback.setOnClickListener(this);
        btnEditProfile.setOnClickListener(this);
        btnSingOut.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_social_network:
                break;
            case R.id.layout_travel_guide:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
            case R.id.layout_notification:
                NotificationDialog notificationDialog=new NotificationDialog(this);
                notificationDialog.createNotificationDialog();
                notificationDialog.showNotificationDialog();
                break;
            case R.id.layout_help:
                HelpInfoDialog helpInfoDialog=new HelpInfoDialog(this);
                helpInfoDialog.createHelpInfoDialog();
                helpInfoDialog.showHelpInfoDialog();
                break;
            case R.id.btn_edit_profile:
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
                break;
            case R.id.btn_sing_out:
                mAuth.signOut();
                startActivity(new Intent(ProfileActivity.this, StartingActivity.class));
                break;
        }

    }

    private void getProfileInfo() {
        FirebaseUser user = mAuth.getCurrentUser();
        String tempStringUserFullName = user.getDisplayName();
        if (!tempStringUserFullName.isEmpty()) {
            textViewUserName.setText(tempStringUserFullName);
        }
//        user.getPhotoUrl();
    }
}
