package com.example.vjti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.clubs.clubs;
import com.example.e_resources.btech;
import com.example.firstyear.firstyear;
import com.example.fourthyear.fourthyear;
import com.example.second.secondyear;
import com.example.thirdyear.thirdyear;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cgpakoto.com.cgpa.Activities.Calculator;
import cgpakoto.com.cgpa.Activities.Home;

public class year extends AppCompatActivity {

    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        //bottom navigation
        bottomnav = findViewById(R.id.bottom_navigator_home);
        bottomnav.setSelectedItemId(R.id.home);
        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.acad:
                        Intent intent_home = new Intent(year.this, year.class);
                        startActivity(intent_home);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.cgpa:
                        Intent intent_categories = new Intent(year.this, Home.class);
                        startActivity(intent_categories);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.clubs:
                        Intent intent_cart = new Intent(year.this, clubs.class);
                        startActivity(intent_cart);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.eresource:
                        Intent intent_profile = new Intent(year.this, btech.class);
                        startActivity(intent_profile);
                        overridePendingTransition(0,0);
                        break;

                }

                return true;
            }
        });




    }
    public void openthree(View v){
        Intent intent = new Intent(this, thirdyear.class);
        startActivity(intent);}
    public void openfirst(View v){
        Intent intent = new Intent(this, firstyear.class);
        startActivity(intent);

        }
        public void openfour(View v ){
        Intent intent = new Intent(this, fourthyear.class);
        startActivity(intent);
        }
        public void opensecond(View v){
        Intent intent = new Intent(this, secondyear.class);
        startActivity(intent);
        }


}
