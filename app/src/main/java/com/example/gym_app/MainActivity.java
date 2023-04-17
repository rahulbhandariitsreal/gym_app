package com.example.gym_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.gym_app.adapter.SimplepagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    ViewPager2 viewPager2;
    SimplepagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager2=findViewById(R.id.viewPager2);

        adapter=new SimplepagerAdapter(getSupportFragmentManager(),getLifecycle());

        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        new TabLayoutMediator(tabLayout, viewPager2,
//                (tab, position) -> tab.setText("OBJECT " + (position + 1))
//        ).attach();

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout,viewPager2,(tab, position) -> {
            if(position==0){
                tab.setText("Diet Plan");
            }else if(position==1){
                tab.setText("Gym Plan");
            }else if(position==2) {
                tab.setText("BMI");
            }
        });
        tabLayoutMediator.attach();






    }
}