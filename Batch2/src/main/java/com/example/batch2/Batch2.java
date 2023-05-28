package com.example.batch2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Batch2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch2);
    }
    public void goto_timetable(View view)
    {
        Intent intent=new Intent(this,timetable2.class);
        startActivity(intent); }
    public void goto_syllabus(View view)
    {
        Intent intent=new Intent(this, syllabus2.class);
        startActivity(intent); }

    public void goto_grade(View view)
    {
        Intent intent=new Intent(this, grade2.class);
        startActivity(intent); }
}
