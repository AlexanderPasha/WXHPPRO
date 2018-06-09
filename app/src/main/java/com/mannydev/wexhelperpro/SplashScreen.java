package com.mannydev.wexhelperpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        for (int i =0;i<100000000;i++){
            int a=i+i;
        }
        startActivity(intent);
        finish();
    }
}
