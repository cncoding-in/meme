package com.cncoding.meme.auth;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cncoding.meme.R;


public class ChangePassword extends AppCompatActivity {

    TextView Password_new;
    LinearLayout Change_password_card;
    Button Change_password_save_btn;
    //int visibility =  1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        setSystemBarColor(this, R.color.background_grey);

        Password_new = findViewById(R.id.change_password_new);
        Change_password_card = findViewById(R.id.change_password_card);
        Change_password_save_btn = findViewById(R.id.change_password_save_btn);

        Change_password_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Change_password_card.setVisibility(View.VISIBLE);
            }
        });

    }

//    public void ShowPasswordCheckBoxListener(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        switch (view.getId()) {
//            case R.id.button1:
//                if (!checked)
//                    password1.setTransformationMethod(new PasswordTransformationMethod());  //hide the password from the edit text
//                else
//                    password1.setTransformationMethod(new DoNothingTransformation()); //show the password from the edit text
//                break;
//            case R.id.button2:
//                if (!checked)
//                    password2.setTransformationMethod(new PasswordTransformationMethod()); //hide the password from the edit text
//                else
//                    password2.setTransformationMethod(null); // another option show the password from the edit text
//                break;
//        }
//    }

    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }
}