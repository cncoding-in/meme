package com.cncoding.meme.dashboard;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.cncoding.meme.R;
import com.cncoding.meme.account.Account;
import com.cncoding.meme.todolist.ToDoList;
import com.cncoding.meme.vitals.Vitals;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {
    private BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setSystemBarColor(this, R.color.Primary_bg);

        navigation = findViewById(R.id.navigation);
        initComponent();
    }

    private void initComponent() {
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:

                        return true;
                    case R.id.TodoList:
                        Intent todolist = new Intent(Dashboard.this, ToDoList.class);
                        startActivity(todolist);
                        return true;
                    case R.id.Vital:
                        Intent vital = new Intent(Dashboard.this, Vitals.class);
                        startActivity(vital);
                        return true;
                    case R.id.More:
                        Intent more = new Intent(Dashboard.this, Account.class);
                        startActivity(more);
                        return true;
                }
                return false;
            }
        });
    }


    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }
}