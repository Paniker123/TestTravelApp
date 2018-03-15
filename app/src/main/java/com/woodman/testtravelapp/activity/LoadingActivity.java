package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.woodman.testtravelapp.R;

public class LoadingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        onProgress();


    }

    //todo: need change into runtime permission check
    private void onProgress() {
        progressBar.setProgress(0);
        progressBar.setMax(100);
        Thread progressBackgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i == 25 || i == 50 || i == 75 || i == 99) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressBar.setProgress(i);

                    }
                }
                if (user == null) {
                    startActivity(new Intent(LoadingActivity.this, StartingActivity.class));
                } else {
                    startActivity(new Intent(LoadingActivity.this, ProfileActivity.class));
                }

            }
        });
        progressBackgroundThread.start();
    }


}
