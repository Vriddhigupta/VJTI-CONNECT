package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pr extends AppCompatActivity {
    private Button ttpr;
    private Button sylpr;
    private Button gradespr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ttpr = (Button) findViewById(R.id.ttpr);
        ttpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        sylpr = (Button) findViewById(R.id.syllabuspr);
        sylpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradespr = (Button) findViewById(R.id.gradespr);
        gradespr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTPR.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SLYPR.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , GRADESPR.class);
        startActivity(intent);
    }


}
