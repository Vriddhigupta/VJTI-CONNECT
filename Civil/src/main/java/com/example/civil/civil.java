package com.example.civil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.civil.CIVIL_TT;

public class civil extends AppCompatActivity {
    private Button button33;
    private Button button35;
    private Button button37;
    private Button button40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        button33 = (Button)findViewById(R.id.button33);
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCIVIL_TT();
            }
        });
        button35 = (Button)findViewById(R.id.button35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCIVIL_Syllabus();
            }
        });
        button37 = (Button)findViewById(R.id.button37);
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCIVIL_grade();
            }
        });
        button40 = (Button)findViewById(R.id.button40);
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCIVIL_Grades();
            }
        });
    }
    public void openCIVIL_TT(){
        Intent intent = new Intent(this, CIVIL_TT.class);
        startActivity(intent);
    }
    public void openCIVIL_Syllabus(){
        Intent intent = new Intent(this, CIVIL_Syllabus.class);
        startActivity(intent);
    }
    public void openCIVIL_grade(){
        Intent intent = new Intent(this, CIVIL_grade.class);
        startActivity(intent);
    }
    public void openCIVIL_Grades(){
        Intent intent = new Intent(this,CIVIL_Grades.class);
        startActivity(intent);
    }
}
