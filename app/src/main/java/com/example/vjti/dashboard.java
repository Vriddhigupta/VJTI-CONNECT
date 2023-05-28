package com.example.vjti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.clubs.clubs;

import com.example.e_resources.btech;
import com.example.e_resources.resources;
import com.example.events.events;

import java.util.ArrayList;
import java.util.List;

import cgpakoto.com.cgpa.Activities.Home;

public class
dashboard extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //carousel
//        viewPager2 = findViewById(R.id.viewPagerImageSlider);
//        List<SliderItems> sliderItems = new ArrayList<>();
//        sliderItems.add(new SliderItems(R.drawable.slider_image1));
////        sliderItems.add(new SliderItems(R.drawable.slider_image2));
////        sliderItems.add(new SliderItems(R.drawable.slider_image3));
//        sliderItems.add(new SliderItems(R.drawable.slider_image4));
//        sliderItems.add(new SliderItems(R.drawable.slider_image5));
//
//        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
//
//        viewPager2.setClipToPadding(false);
//        viewPager2.setClipChildren(false);
//        viewPager2.setOffscreenPageLimit(3);
//        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1-Math.abs(position);
//                page.setScaleY(0.90f + r * 0.18f);
//            }
//        });
//
//        viewPager2.setPageTransformer(compositePageTransformer);
//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                sliderHandler.removeCallbacks(sliderRunnable);
//                sliderHandler.postDelayed(sliderRunnable, 5000); // slide duration 2 seconds
//            }
//        });
    }


    public void openevent(View v){
        Intent intent = new Intent(this, events.class);
        startActivity(intent);
    }
    public void openyear(View v){
        Intent intent = new Intent(this,year.class);
        startActivity(intent);
    }
    public void openclub(View v){
        Intent intent = new Intent(this, clubs.class);
        startActivity(intent);
    }

    public void opencalculator(View v){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void openresource(View v){
        Intent intent = new Intent(this, btech.class);
        startActivity(intent);
    }
//
//    private Runnable sliderRunnable = new Runnable() {
//        @Override
//        public void run() {
//            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
//        }
//    };
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        sliderHandler.removeCallbacks(sliderRunnable);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        sliderHandler.postDelayed(sliderRunnable, 2000);
//    }

}
