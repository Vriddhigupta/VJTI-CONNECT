package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class enthusia extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enthusia);
        TextView web3 = (TextView)findViewById(R.id.web3);
        web3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView fb3 = (TextView)findViewById(R.id.fb3);
        fb3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView insta3 = (TextView)findViewById(R.id.insta3);
        insta3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView youtube3 = (TextView)findViewById(R.id.youtube3);
        youtube3.setMovementMethod(LinkMovementMethod.getInstance());
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderDotspanel =(LinearLayout)findViewById(R.id.SliderDots);
        ViewPagerAdapter3 viewPagerAdapter3 = new ViewPagerAdapter3(this);
        viewPager.setAdapter(viewPagerAdapter3);
        dotscount= viewPagerAdapter3.getCount();
        dots = new ImageView[dotscount];
        for(int i=0;i<dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0; i<dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

