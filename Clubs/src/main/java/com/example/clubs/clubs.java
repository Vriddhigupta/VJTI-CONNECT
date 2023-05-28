package com.example.clubs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cgpakoto.com.cgpa.Activities.Home;

public class clubs extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    BottomNavigationView bottomnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.btn_coc);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCoc();
            }
        });

        button2 = (Button) findViewById(R.id.btn_sra);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSra();
            }
        });

        button3 = (Button) findViewById(R.id.btn_dla);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDla();
            }
        });

        button4 = (Button) findViewById(R.id.btn_gdsc);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGdsc();
            }
        });

        button5 = (Button)  findViewById(R.id.btn_prati);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrati();
            }
        });

        button6 = (Button)  findViewById(R.id.btn_techno);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTechno();
            }
        });


        //bottom navigation
        bottomnav = findViewById(R.id.bottom_navigator_home);
        bottomnav.setSelectedItemId(R.id.clubs);
        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.acad) {
//                    Intent intent_home = new Intent(clubs.this, year.class);
//                    startActivity(intent_home);
//                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.cgpa) {
                    Intent intent_categories = new Intent(clubs.this, Home.class);
                    startActivity(intent_categories);
                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.clubs) {
                    Intent intent_cart = new Intent(clubs.this, clubs.class);
                    startActivity(intent_cart);
                    overridePendingTransition(0, 0);
                } else if (itemId == R.id.eresource) {
//                    Intent intent_profile = new Intent(clubs.this, btech.class);
//                    startActivity(intent_profile);
//                    overridePendingTransition(0, 0);
                }

                return true;
            }
        });




    }
    public void openCoc()
    {
        Intent intent = new Intent(this, Coc.class);
        startActivity(intent);

    }

    public void openSra()
    {
        Intent intent = new Intent(this, Sra.class);
        startActivity(intent);

    }

    public void openDla()
    {
        Intent intent = new Intent(this, Dla.class);
        startActivity(intent);

    }

    public void openGdsc()
    {
        Intent intent = new Intent(this, Gdsc.class);
        startActivity(intent);

    }

    public void openPrati()
    {
        Intent intent = new Intent(this, Prati.class);
        startActivity(intent);

    }

    public void openTechno()
    {
        Intent intent = new Intent(this, Techno.class);
        startActivity(intent);

    }
}
