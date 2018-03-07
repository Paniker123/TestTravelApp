package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.woodman.testtravelapp.R;

public class LoadingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar=findViewById(R.id.progressBar);
        onProgress();

    }

    private void onProgress(){

        progressBar.setProgress(0);
        progressBar.setMax(100);
        Thread progressBackgroundThread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if(i==25||i==50||i==75||i==99){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    progressBar.setProgress(i);

                    }
                }
                startActivity(new Intent(LoadingActivity.this,StartingActivity.class));
            }
        });
        progressBackgroundThread.start();



    }
}
