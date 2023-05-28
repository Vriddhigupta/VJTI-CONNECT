package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mech extends AppCompatActivity {
    private Button ttme;
    private Button sylme;
    private Button gradesme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ttme = (Button) findViewById(R.id.ttm);
        ttme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        sylme = (Button) findViewById(R.id.syllabusm);
        sylme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradesme = (Button) findViewById(R.id.gradesm);
        gradesme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTME.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SYLME.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , Gradesme.class);
        startActivity(intent);
    }


}