package com.example.secondyearit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SyIt extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;

    public static final String Pref_username = "SY_IT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy_it);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimeTable();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabus();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGrade();
            }
        });



    }
    public void openTimeTable()
    {
        Intent intent = new Intent(this, TimeTableit.class);
        startActivity(intent);

    }

    public void openSyllabus()
    {
        Intent intent = new Intent(this, Syllabussyit.class);
        startActivity(intent);

    }

    public void openGrade()
    {
        Intent intent = new Intent(this, Gradesyit.class);
        startActivity(intent);

    }

}
