package com.example.gym_app.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gym_app.fragment.bmi_fragment;
import com.example.gym_app.fragment.diet_fragment;
import com.example.gym_app.fragment.gym_plan_fragment;

public class SimplepagerAdapter extends FragmentStateAdapter {


    public SimplepagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }



    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                Fragment fragment = new diet_fragment();
                Bundle args = new Bundle();
                // Our object is just an integer :-P
                args.putInt("object",position);
                fragment.setArguments(args);
                return fragment;
            case 1:
                Fragment fragment2 = new gym_plan_fragment();
                Bundle args2 = new Bundle();
                // Our object is just an integer :-P
                args2.putInt("object",position);
                fragment2.setArguments(args2);
                return fragment2;
            case 2:
                Fragment fragment3 = new bmi_fragment();
                Bundle args3 = new Bundle();
                // Our object is just an integer :-P
                args3.putInt("object",position);
                fragment3.setArguments(args3);
                return fragment3;

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
