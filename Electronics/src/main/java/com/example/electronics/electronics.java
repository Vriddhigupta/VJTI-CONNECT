package com.example.electronics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class electronics extends AppCompatActivity {
    private Button button21;
    private Button button23;
    private Button button46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        button21 = (Button)findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEC_TT();
            }
        });
        button23 = (Button)findViewById(R.id.button23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEC_Syllabus();
            }
        });
        button46 = (Button)findViewById(R.id.button46);
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEC_Grades();
            }
        });
    }
    public void openEC_TT(){
        Intent intent = new Intent(this, EC_TT.class);
        startActivity(intent);
    }
    public void openEC_Syllabus(){
        Intent intent = new Intent(this, EC_Syllabus.class);
        startActivity(intent);
    }
    public void openEC_Grades(){
        Intent intent = new Intent(this,EC_Grades.class);
        startActivity(intent);
    }
}
