package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ranga extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranga);

        TextView fb2 = (TextView)findViewById(R.id.fb2);
        fb2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView insta2 = (TextView)findViewById(R.id.insta2);
        insta2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView youtube2 = (TextView)findViewById(R.id.youtube2);
        youtube2.setMovementMethod(LinkMovementMethod.getInstance());
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderDotspanel =(LinearLayout)findViewById(R.id.SliderDots);
        ViewPagerAdapter2 viewPagerAdapter2 = new ViewPagerAdapter2(this);
        viewPager.setAdapter(viewPagerAdapter2);
        dotscount= viewPagerAdapter2.getCount();
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
