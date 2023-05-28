package com.example.computer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class computer extends AppCompatActivity {
    Button button17;
    Button button19;
    Button button42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        button17 = (Button)findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCOMP_TT();
            }
        });
        button19 = (Button)findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCOMP_Syllabus();
            }
        });
        button42 = (Button)findViewById(R.id.button42);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCOMP_Grades();
            }
        });
    }
    public void openCOMP_TT(){
        Intent intent =new  Intent(this, COMP_TT.class);
        startActivity(intent);
    }
    public void openCOMP_Syllabus(){
        Intent intent = new Intent(this, COMP_Syllabus.class);
        startActivity(intent);
    }
    public void openCOMP_Grades(){
        Intent intent = new Intent(this, COMP_Grades.class);
        startActivity(intent);
    }
}
