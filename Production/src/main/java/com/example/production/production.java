package com.example.production;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class production extends AppCompatActivity {
    Button button9;
    Button button11;
    Button button52;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);

        button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprodtt();
            }
        });
        button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprodsyllabus();
            }
        });
        button52 = (Button)findViewById(R.id.button52);
        button52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprodgrades();
            }
        });
    }
    public void openprodtt(){
        Intent intent = new Intent(this,PROD_TT.class);
        startActivity(intent);
    }
    public void openprodsyllabus(){
        Intent intent = new Intent(this,PROD_Syllabus.class);
        startActivity(intent);
    }
    public void openprodgrades(){
        Intent intent = new Intent(this,PROD_Grades.class);
        startActivity(intent);
    }
}
