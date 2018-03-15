package com.woodman.testtravelapp.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.woodman.testtravelapp.FirebaseDBHelper.DBImpl.UserDBImpl;
import com.woodman.testtravelapp.FirebaseDBHelper.UserDB;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.dialog.ChangeNameDialog;
import com.woodman.testtravelapp.model.User;

import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    private ImageView imageViewProfileAvatar;

    private TextView textViewUserName;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextGender;
    private EditText editTextAge;
    private EditText editTextPhone;

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private UserDB userDB;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        user = new User();
        userDB = new UserDBImpl();

        imageViewProfileAvatar = findViewById(R.id.image_view_profile_avatar_edit_activity);

        editTextEmail = findViewById(R.id.edit_text_email_edit_profile_activity);
        editTextPassword = findViewById(R.id.edit_text_password_edit_profile_activity);
        editTextGender = findViewById(R.id.edit_text_gender_edit_profile_activity);
        editTextAge = findViewById(R.id.edit_text_age_edit_profile_activity);
        editTextPhone = findViewById(R.id.edit_text_phone_edit_profile_activity);
        textViewUserName = findViewById(R.id.text_view_user_name_edit_profile_activity);


        getCurrentUserInfo();

        imageViewProfileAvatar.setOnClickListener(this);
        textViewUserName.setOnClickListener(this);

        editTextEmail.setOnKeyListener(this);
        editTextPassword.setOnKeyListener(this);
        editTextGender.setOnKeyListener(this);
        editTextAge.setOnKeyListener(this);
        editTextPhone.setOnKeyListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_view_profile_avatar_edit_activity:
                break;
            case R.id.text_view_user_name_edit_profile_activity:
                ChangeNameDialog changeNameDialog = new ChangeNameDialog(this);
                changeNameDialog.createChangeNameDialog();
                onRestart();
                break;
        }
    }

    //todo:complete validation


    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        switch (view.getId()) {
            case R.id.edit_text_email_edit_profile_activity:
                if (keyCode == EditorInfo.IME_ACTION_GO || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isEmailValid()) {
                        userDB.updateUserEmail(firebaseUser, editTextEmail.getText().toString());
                        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.edit_text_password_edit_profile_activity:

                if (keyCode == EditorInfo.IME_ACTION_GO || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isPasswordValid()) {
                        userDB.updateUserPassword(firebaseUser, editTextPassword.getText().toString());
                        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.edit_text_gender_edit_profile_activity:
                if (keyCode == EditorInfo.IME_ACTION_GO || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isGenderValid()) {
                        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.edit_text_age_edit_profile_activity:
                if (keyCode == EditorInfo.IME_ACTION_GO || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isAgeValid()) {
                        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.edit_text_phone_edit_profile_activity:
//                !Patterns.PHONE
                if (keyCode == EditorInfo.IME_ACTION_GO || keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (isPhoneValid()) {
                        Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return false;
    }

    private void getCurrentUserInfo() {
        textViewUserName.setText(firebaseUser.getDisplayName());
        editTextEmail.setText(firebaseUser.getEmail());
    }

    private boolean isEmailValid() {
        String tempEmail = editTextEmail.getText().toString();
        if (tempEmail.isEmpty()) {
            editTextEmail.setError(getString(R.string.error_missing_email));
            editTextEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tempEmail).matches()) {
            editTextEmail.setError(getString(R.string.error_email_mistake));
            editTextEmail.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isPasswordValid() {
        String tempPassword = editTextPassword.getText().toString();
        if (tempPassword.isEmpty()) {
            editTextPassword.setError(getString(R.string.error_missing_password));
            editTextPassword.requestFocus();
            return false;
        }
        if (tempPassword.length() < 6) {
            editTextPassword.setError(getString(R.string.error_password_mistake));
            editTextPassword.requestFocus();
            return false;
        }
        return true;
    }


    private boolean isGenderValid() {
        String tempGender = editTextGender.getText().toString();
        if (tempGender.isEmpty()) {
            editTextGender.setError(getString(R.string.error_missing_gender));
            editTextGender.requestFocus();
            return false;
        }
        if (!(tempGender.equals("male") || tempGender.equals("female"))){
            editTextGender.setError(getString(R.string.error_gender_mistake));
            editTextGender.requestFocus();
            return false;
        }
        return true;
    }

    //todo:complete
    private boolean isAgeValid() {
        String temp_age=editTextAge.getText().toString();
        if(temp_age.isEmpty()){
            editTextAge.setError(getString(R.string.error_missing_age));
            editTextAge.requestFocus();
            return false;
        }
        if(Integer.parseInt(temp_age)>=120){
            editTextAge.setError(getString(R.string.error_age_mistake)+120);
            editTextAge.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isPhoneValid() {
        String temp_phone = editTextPhone.getText().toString();
        if (temp_phone.isEmpty()) {
            editTextPhone.setError(getString(R.string.error_missing_phone));
            editTextPhone.requestFocus();
            return false;
        }
        if (temp_phone.length()<13||temp_phone.length()>13) {
            editTextPhone.setError(getString(R.string.error_phone_mistake));
            editTextPhone.requestFocus();
            return false;
        }
        if(!temp_phone.contains("+")){
            editTextPhone.setError(getString(R.string.error_phone_mistake));
            editTextPhone.requestFocus();
            return false;
        }

        return true;
    }
}
