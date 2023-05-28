package com.example.electrical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class electrical extends AppCompatActivity {
    private Button button5;
    private Button button6;
    private Button button44;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openEL_TT();
            }
        });
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEL_Syllabus();
            }
        });
        button44 = findViewById(R.id.button44);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEL_Grades();
            }
        });
    }
    public void openEL_TT(){
        Intent intent  = new Intent(this,EL_TT.class);
                startActivity(intent);
    }
    public void openEL_Syllabus(){
        Intent intent = new Intent(this, EL_Syllabus.class);
        startActivity(intent);
    }
    public void openEL_Grades(){
        Intent intent = new Intent(this,EL_Grades.class);
        startActivity(intent);
    }
}
