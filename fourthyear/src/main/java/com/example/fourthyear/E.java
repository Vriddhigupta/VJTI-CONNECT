package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class E extends AppCompatActivity {
    private Button tte;
    private Button syle;
    private Button gradee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tte = (Button) findViewById(R.id.tte);
        tte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        syle = (Button) findViewById(R.id.syllabue);
        syle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradee = (Button) findViewById(R.id.gradee);
        gradee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTE.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SYLE.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , GRADEE.class);
        startActivity(intent);
    }


}