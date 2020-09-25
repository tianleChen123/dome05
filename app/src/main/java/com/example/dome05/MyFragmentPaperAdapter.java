package com.example.dome05;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPaperAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private DialPadFragment dialPadFragment = null;
    private RecentFragment recentFragment = null;
    private PersonFragment personFragment = null;

    public MyFragmentPaperAdapter(FragmentManager fm) {
        super(fm);
        dialPadFragment = new DialPadFragment();
        recentFragment = new RecentFragment();
        personFragment = new PersonFragment();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        System.out.println("position Destroy" + position);
        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = dialPadFragment;
                break;
            case 1:
                fragment = recentFragment;
                break;
            case 2:
                fragment = personFragment;
                break;
        }
        return fragment;
    }

}
