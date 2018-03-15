package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.woodman.testtravelapp.FirebaseDBHelper.DBImpl.UserDBImpl;
import com.woodman.testtravelapp.FirebaseDBHelper.UserDB;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.model.User;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFullName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnSingUp;
    private Button btnSingUpWithFacebook;
    private TextView textViewSingIn;

    private FirebaseAuth mAuth;
    private User user;
    private UserDB userDB;

    private static String TAG="SingUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        editTextFullName = findViewById(R.id.edit_text_sing_up_activity_full_name);
        editTextEmail = findViewById(R.id.edit_text_sing_up_activity_email);
        editTextPassword = findViewById(R.id.edit_text_sing_up_activity_password);
        btnSingUp = findViewById(R.id.btn_sing_up);
        btnSingUpWithFacebook = findViewById(R.id.btn_sing_up_with_facebook);
        textViewSingIn = findViewById(R.id.sing_up_activity_textView_sing_in);
        mAuth = FirebaseAuth.getInstance();
        user = new User();
        userDB = new UserDBImpl();
        btnSingUp.setOnClickListener(this);
        btnSingUpWithFacebook.setOnClickListener(this);
        textViewSingIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sing_up:
                if (validationForm()) {
                    userCredentialsFromForm();
                    registerUser(user);
                }
                break;
            case R.id.btn_sing_up_with_facebook:
                //TODO: Create account with facebook, takes user info and save in firebase
                break;
            case R.id.sing_up_activity_textView_sing_in:
                startActivity(new Intent(SingUpActivity.this, SingInActivity.class));
                break;
        }
    }

    private void registerUser(final User user) {
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SingUpActivity.this, getString(R.string.success), Toast.LENGTH_SHORT).show();
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            userDB.setUserName(firebaseUser, user.getFullName());
                            startActivity(new Intent(SingUpActivity.this, SingInActivity.class));
                        } else {
                            Log.w(TAG,task.getException());
                            Toast.makeText(SingUpActivity.this, getString(R.string.fail), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void userCredentialsFromForm() {
        user.setFullName(editTextFullName.getText().toString());
        user.setEmail(editTextEmail.getText().toString());
        user.setPassword(editTextPassword.getText().toString());
    }

    private boolean validationForm() {
        String tempFullName = editTextFullName.getText().toString();
        String tempEmail = editTextEmail.getText().toString();
        String tempPassword = editTextPassword.getText().toString();
        if (tempFullName.isEmpty()) {
            editTextFullName.setError(getString(R.string.error_missing_full_name));
            editTextEmail.requestFocus();
            return false;
        }
        if (tempEmail.isEmpty()) {
            editTextEmail.setError(getString(R.string.error_missing_email));
            editTextEmail.requestFocus();
            return false;
        }
        if (tempPassword.isEmpty()) {
            editTextPassword.setError(getString(R.string.error_missing_password));
            editTextPassword.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tempEmail).matches()) {
            editTextEmail.setError(getString(R.string.error_email_mistake));
            editTextEmail.requestFocus();
            return false;
        }
        if(tempPassword.length()<6){
            editTextPassword.setError(getString(R.string.error_password_mistake));
            editTextPassword.requestFocus();
            return false;
        }

        return true;
    }
}
