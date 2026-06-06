package com.example.midbayan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();

            case 1:
                return new SecondFragment();

            default:
                return new ThirdFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}