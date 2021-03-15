package com.example.myfragment.ui.main;

import android.content.Context;
import android.icu.text.CaseMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myfragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List <Fragment> fragments = new ArrayList<>();
    private List <String> Title = new ArrayList<>();

    public   ViewPagerAdapter (@NonNull FragmentManager fm, int behavior){
        super(fm, behavior);

    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

//    @StringRes
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
//    private final Context mContext;

public void addFragment (Fragment fragment, String title){
        fragments.add(fragment);
        Title.add(title);
}




    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Title.get(position);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return fragments.size();
    }
}