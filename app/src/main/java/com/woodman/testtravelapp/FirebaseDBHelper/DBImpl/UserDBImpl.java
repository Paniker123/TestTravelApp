package com.woodman.testtravelapp.FirebaseDBHelper.DBImpl;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.woodman.testtravelapp.FirebaseDBHelper.UserDB;

public class UserDBImpl implements UserDB {
    private static String TAG = "UserBD";


    @Override
    public void setUserName(FirebaseUser user, String name) {
        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        user.updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.w(TAG, "Save name success");
                } else {
                    Log.w(TAG, "Save name fail");
                }
            }
        });
    }

    @Override
    public void updateUserEmail(FirebaseUser user, String email) {
        user.updateEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.w(TAG, "Update email success");
                } else {
                    Log.w(TAG, "Update email fail");
                }
            }
        });


    }

    @Override
    public void updateUserPassword(FirebaseUser user, String password) {
        user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.w(TAG, "Update password success");
                } else {
                    Log.w(TAG, "Update password fail");
                }
            }
        });


    }
}
