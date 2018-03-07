package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.woodman.testtravelapp.R;

public class StartingActivity extends AppCompatActivity {

    private Button btnSingIn;
    private Button btnSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        btnSingIn=findViewById(R.id.btn_sing_in_starting_activity);
        btnSingUp=findViewById(R.id.btn_sing_up_starting_activity);


        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivity.this,SingInActivity.class));
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivity.this,SingUpActivity.class));
            }
        });

    }
}
