package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.woodman.testtravelapp.R;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextFullName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnSingUp;
    private Button btnSingUpWithFacebook;
    private TextView textViewSingIn;


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


        btnSingUp.setOnClickListener(this);
        btnSingUpWithFacebook.setOnClickListener(this);
        textViewSingIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sing_up:
                //TODO: Create account and save it in firebase
                break;
            case R.id.btn_sing_up_with_facebook:
                //TODO: Create account with facebook, takes user info and save in firebase
                break;
            case R.id.sing_up_activity_textView_sing_in:
                startActivity(new Intent(SingUpActivity.this, SingInActivity.class));
                break;
        }
    }
}
