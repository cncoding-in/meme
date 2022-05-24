package com.cncoding.meme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.cncoding.meme.account.Account;
import com.cncoding.meme.account.MyInfo;
import com.cncoding.meme.auth.ChangePassword;
import com.cncoding.meme.auth.Login;
import com.cncoding.meme.dashboard.Dashboard;

public class SplashScreen extends AppCompatActivity {
    int SPLASH_SCREEN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }

}