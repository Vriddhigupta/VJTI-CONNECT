package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fourthyear.ui.login.LoginCs;

public class Cs extends AppCompatActivity {

    private Button tt;
    private Button syllabus;
    private Button grades;
    private Button logout;
    public static final String Pref_username = "FOURTH_YR_COMP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tt = (Button) findViewById(R.id.tt);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTT();
            }
        });
        syllabus = (Button) findViewById(R.id.syllabus);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSYl();
            }
        });

        grades = (Button) findViewById(R.id.grades);
        grades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGrade();
            }
        });


    }

    public void openTT() {
        Intent intent = new Intent(this, TimeTable.class);
        startActivity(intent);
    }

    public void openSYl() {
        Intent intent = new Intent(this, SyllabusCs.class);
        startActivity(intent);
    }

    public void openGrade() {
        Intent intent = new Intent(this, GradeCs.class);
        startActivity(intent);
    }

    public void openLogin()
    {
        SharedPreferences settings = getSharedPreferences(Pref_username, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("logged");
        editor.commit();
        finish();
        Intent intent = new Intent(Cs.this, LoginCs.class);
        startActivity(intent);
    }
}

