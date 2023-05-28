package com.example.batch5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Batch5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main5);}

        public void goto_timetable (View view)
        {
            Intent intent = new Intent(this, timetable5.class);
            startActivity(intent);
        }
        public void goto_syllabus (View view)
        {
            Intent intent = new Intent(this, syllabus5.class);
            startActivity(intent);
        }
    public void goto_grade(View view)
    {
        Intent intent=new Intent(this, grade5.class);
        startActivity(intent); }
    }
