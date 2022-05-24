package com.cncoding.meme.account;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.cncoding.meme.R;
import com.cncoding.meme.adapter.MyInfoVPadapter;
import com.cncoding.meme.fragment.Communicn;
import com.cncoding.meme.fragment.PersonalFragment;
import com.cncoding.meme.fragment.Preference;
import com.google.android.material.tabs.TabLayout;

public class MyInfo extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        setSystemBarColor(this, R.color.background2);

        tabLayout = findViewById(R.id.myinfo_tablayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        MyInfoVPadapter myInfoVPadapter = new MyInfoVPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myInfoVPadapter.adFragment(new PersonalFragment(),"Personal");
        myInfoVPadapter.adFragment(new Communicn(),"Communicn");
        myInfoVPadapter.adFragment(new Preference(),"Preference");
        viewPager.setAdapter(myInfoVPadapter);

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