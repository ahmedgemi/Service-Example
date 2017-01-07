package com.example.ahmed.service_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start (View v){

        Intent intent = new Intent(this,myService.class);
        startService(intent);
    }

    public void stop (View v){


        Intent intent = new Intent(this,myService.class);
        stopService(intent);
    }
}
