package com.example.e_resources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.clubs.clubs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cgpakoto.com.cgpa.Activities.Home;

public class btech extends AppCompatActivity {

    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech);


        //bottom navigation
        bottomnav = findViewById(R.id.bottom_navigator_home);
        bottomnav.setSelectedItemId(R.id.eresource);
        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.acad) {
//                    Intent intent_home = new Intent(btech.this, com.example..class);
//                    startActivity(intent_home);
//                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.cgpa) {
                    Intent intent_categories = new Intent(btech.this, Home.class);
                    startActivity(intent_categories);
                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.clubs) {
                    Intent intent_cart = new Intent(btech.this, clubs.class);
                    startActivity(intent_cart);
                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.eresource) {
                    Intent intent_profile = new Intent(btech.this, btech.class);
                    startActivity(intent_profile);
                    overridePendingTransition(0, 0);
                }

                return true;
            }
        });




    }
    public void goto_fybtech(View view)
    {
        Intent intent=new Intent(this,fybtech.class);
        startActivity(intent); }
    public void goto_sybtech(View view)
    {
        Intent intent=new Intent(this,sybtech.class);
        startActivity(intent); }
    public void goto_tybtech(View view)
    {
        Intent intent=new Intent(this,tybtech.class);
        startActivity(intent); }
    public void goto_finalyearbtech(View view)
    {
        Intent intent=new Intent(this,finalyearbtech.class);
        startActivity(intent); }
}
