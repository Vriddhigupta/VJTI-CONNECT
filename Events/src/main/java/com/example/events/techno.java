package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class techno extends AppCompatActivity {
ViewPager viewPager;
LinearLayout sliderDotspanel;
private int dotscount;
private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techno);
TextView web = (TextView)findViewById(R.id.web);
web.setMovementMethod(LinkMovementMethod.getInstance());
        TextView fb = (TextView)findViewById(R.id.fb);
        fb.setMovementMethod(LinkMovementMethod.getInstance());
        TextView insta = (TextView)findViewById(R.id.insta);
        insta.setMovementMethod(LinkMovementMethod.getInstance());
        TextView youtube = (TextView)findViewById(R.id.youtube);
        youtube.setMovementMethod(LinkMovementMethod.getInstance());
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderDotspanel =(LinearLayout)findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount= viewPagerAdapter.getCount();
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
