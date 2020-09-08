package com.i2i.findstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // create shared pref for cheking is login or not...
        preferences = getSharedPreferences("findstident", MODE_PRIVATE);
        editor = preferences.edit();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(!preferences.getString("islogin", " ").equals(" "))
                {
                    System.out.println("Already Login");
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                else {
                    System.out.println("Take to Login Screen");
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }
        },1000);

    }
}
