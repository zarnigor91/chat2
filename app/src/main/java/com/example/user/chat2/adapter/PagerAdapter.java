package com.example.user.chat2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.chat2.fragment.ItemFragment;
import com.example.user.chat2.model.User;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    private ArrayList<User> data;
    public PagerAdapter(FragmentManager fm, ArrayList<User> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int i) {
        return ItemFragment.getIntance(data);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0: return "User";
            case 1: return "Group";
            case 2: return  "Chat";
            default: return "";
        }
    }
}
