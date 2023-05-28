package com.example.textile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class textile extends AppCompatActivity {
    Button button13;
    Button button15;
    Button button56;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textile);
        button13 = (Button)findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTEXT_TT();
            }
        });
        button15 = (Button)findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTEXT_Syllabus();
            }
        });
        button56 = (Button)findViewById(R.id.button56);
        button56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTEXT_Grades();
            }
        });
    }
    public void openTEXT_TT(){
        Intent intent = new Intent(this,TEXT_TT.class);
        startActivity(intent);
    }
    public void openTEXT_Syllabus(){
        Intent intent = new Intent(this, TEXT_Syllabus.class);
        startActivity(intent);
    }
    public void openTEXT_Grades(){
        Intent intent = new Intent(this,TEXT_Grades.class);
        startActivity(intent);
    }
}
