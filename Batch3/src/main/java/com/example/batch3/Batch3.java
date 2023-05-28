package com.example.batch3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Batch3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch3);
    }
    public void goto_timetable(View view)
    {
        Intent intent=new Intent(this, timetable3.class);
        startActivity(intent); }
    public void goto_syllabus(View view)
    {
        Intent intent=new Intent(this, syllabus3.class);
        startActivity(intent); }
    public void goto_grade(View view)
    {
        Intent intent=new Intent(this, grade3.class);
        startActivity(intent); }
}
