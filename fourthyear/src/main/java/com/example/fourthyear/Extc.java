package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Extc extends AppCompatActivity {
    private Button ttex;
    private Button sylex;
    private Button gradeex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ttex = (Button) findViewById(R.id.ttex);
        ttex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        sylex = (Button) findViewById(R.id.syllabuex);
        sylex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSS();
            }
        });
        gradeex = (Button) findViewById(R.id.gradeex);
        gradeex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengrade();
            }
        });
    }

    public void openTT()
    {
        Intent intent = new Intent(this , TTEX.class);
        startActivity(intent);
    }
    public void openSS()
    {
        Intent intent = new Intent(this , SYLEX.class);
        startActivity(intent);
    }
    public void opengrade()
    {
        Intent intent = new Intent(this , GRADEX.class);
        startActivity(intent);
    }


}