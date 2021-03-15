package com.example.myfragment;

import android.os.Bundle;
import android.view.View;

import com.example.myfragment.ui.main.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
private  TabLayout tabLayout;
private Fragment1 fragment1;
private Fragment2 fragment2;
private Fragment3 fragment3;
private Fragment4 fragment4;
    private ViewPager  viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(fragment1, "Monday");
        viewPagerAdapter.addFragment(fragment2, "Tuesday");
        viewPagerAdapter.addFragment(fragment3, "Wednesday");
        viewPagerAdapter.addFragment(fragment4, "Thursday");

        viewPager.setAdapter(viewPagerAdapter);

    }

}