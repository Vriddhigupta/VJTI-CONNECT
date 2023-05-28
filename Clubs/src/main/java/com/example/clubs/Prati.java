package com.example.clubs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Prati extends AppCompatActivity {


    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratii);


        TextView web1 = (TextView)findViewById(R.id.web1);
        web1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView fb1 = (TextView)findViewById(R.id.fb1);
        fb1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView insta1 = (TextView)findViewById(R.id.insta1);
        insta1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView youtube1 = (TextView)findViewById(R.id.youtube1);
        youtube1.setMovementMethod(LinkMovementMethod.getInstance());


        //carousel
        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(R.drawable.prati2));
        sliderItems.add(new SliderItems(R.drawable.prati1));
        sliderItems.add(new SliderItems(R.drawable.prati3));
        sliderItems.add(new SliderItems(R.drawable.prati1));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.90f + r * 0.18f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 5000); // slide duration 2 seconds
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    }

    public void link(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}