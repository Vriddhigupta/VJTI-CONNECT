package com.example.batch4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Batch4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch4);
    }
    public void goto_timetable(View view)
    {
        Intent intent=new Intent(this, timetable4.class);
        startActivity(intent); }
    public void goto_syllabus(View view)
    {
        Intent intent=new Intent(this, syllabus4.class);
        startActivity(intent); }

    public void goto_grade(View view)
    {
        Intent intent=new Intent(this, grade4.class);
        startActivity(intent); }
}
