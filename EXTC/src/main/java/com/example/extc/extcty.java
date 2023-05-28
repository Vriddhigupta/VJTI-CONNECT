package com.example.extc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class extcty extends AppCompatActivity {
    private Button button29;
    private Button button31;
    private Button button54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extcty);

        button29 = (Button)findViewById(R.id.button29);
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEXTC_TT();
            }
        });
        button31 = (Button)findViewById(R.id.button31);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEXTC_Syllabus();
            }
        });
        button54 =(Button)findViewById(R.id.button54);
        button54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEXTC_Grades();
            }
        });
    }
    public void openEXTC_TT(){
        Intent intent = new Intent(this, EXTC_TT.class);
        startActivity(intent);
    }
    public void openEXTC_Syllabus(){
        Intent intent = new Intent(this, EXTC_Syllabus.class);
        startActivity(intent);
    }
    public void openEXTC_Grades(){
        Intent intent = new Intent(this, EXTC_Grades.class);
        startActivity(intent);
    }
}
