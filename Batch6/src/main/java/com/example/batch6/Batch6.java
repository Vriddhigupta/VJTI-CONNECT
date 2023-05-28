package com.example.batch6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Batch6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch6);
    }
    public void goto_timetable(View view)
    {
        Intent intent=new Intent(this, timetable6.class);
        startActivity(intent); }
    public void goto_syllabus(View view)
    {
        Intent intent=new Intent(this, syllabus6.class);
        startActivity(intent); }
    public void goto_grade(View view)
    {
        Intent intent=new Intent(this, grade6.class);
        startActivity(intent); }
}
