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
import com.woodman.testtravelapp.R;

public class SingInActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnSingIn;
    private TextView textViewCreateNew;

    private FirebaseAuth mAuth;

    private static String TAG="SingInActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        editTextEmail = findViewById(R.id.edit_text_sing_in_email);
        editTextPassword = findViewById(R.id.edit_text_sing_in_password);
        btnSingIn = findViewById(R.id.btn_sing_in_sing_in_activity);
        textViewCreateNew = findViewById(R.id.sing_in_activity_textView_create_new);

        mAuth = FirebaseAuth.getInstance();

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(validation()){
                 singIn();
             }
            }
        });


        textViewCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingInActivity.this, SingUpActivity.class));
            }
        });
    }

    private void singIn() {
        mAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                Intent intent=new Intent(SingInActivity.this,ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                        } else {
                            Log.w(TAG,task.getException());
                            Toast.makeText(SingInActivity.this,getString(R.string.fail_sing_in),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validation() {
        String tempEmail=editTextEmail.getText().toString();
        String tempPassword=editTextPassword.getText().toString();
        if(tempEmail.isEmpty()){
            editTextEmail.setError(getString(R.string.error_missing_email));
            editTextEmail.requestFocus();
            return false;
        }
        if(tempPassword.isEmpty()){
            editTextPassword.setError(getString(R.string.error_missing_password));
            editTextPassword.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(tempEmail).matches()){
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
