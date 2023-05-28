package com.example.batch1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.*;
public class Batch1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch1);
    }
    public void goto_timetable(View view)
    {
        Intent intent=new Intent(this,timetable.class);
        startActivity(intent); }
    public void goto_syllabus(View view)
    {
        Intent intent=new Intent(this,syllabus.class);
        startActivity(intent); }
    public void goto_grade(View view)
    {
        Intent intent=new Intent(this,grade.class);
        startActivity(intent); }
}
