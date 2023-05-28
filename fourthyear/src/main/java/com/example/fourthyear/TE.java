package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TE extends AppCompatActivity {
    private Button ttte;
    private Button sylte;
    private Button gradeste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_e);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ttte = (Button) findViewById(R.id.ttte);
        ttte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        sylte = (Button) findViewById(R.id.syllabuste);
        sylte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradeste = (Button) findViewById(R.id.gradeste);
        gradeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTTE.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SYLTE.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , GRADESTE.class);
        startActivity(intent);
    }


}
