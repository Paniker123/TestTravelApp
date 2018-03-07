package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.woodman.testtravelapp.R;

public class SingInActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnSingIn;
    private TextView textViewCreateNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        editTextEmail=findViewById(R.id.edit_text_sing_in_email);
        editTextPassword=findViewById(R.id.edit_text_sing_in_password);
        btnSingIn=findViewById(R.id.btn_sing_in_sing_in_activity);
        textViewCreateNew=findViewById(R.id.sing_in_activity_textView_create_new);

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:Authentication
            }
        });



        textViewCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingInActivity.this,SingUpActivity.class));
            }
        });
    }
}
