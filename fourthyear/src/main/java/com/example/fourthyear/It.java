package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class It extends AppCompatActivity {

    private Button tti;
    private Button syli;
    private Button gradesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tti = (Button) findViewById(R.id.tti);
        tti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        syli = (Button) findViewById(R.id.syllabusi);
        syli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradesi = (Button) findViewById(R.id.gradesi);
        gradesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTI.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SYLI.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , GRADESI.class);
        startActivity(intent);
    }


}

