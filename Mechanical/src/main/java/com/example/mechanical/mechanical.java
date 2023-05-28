package com.example.mechanical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mechanical extends AppCompatActivity {
    private Button button25;
    private Button button27;
    private Button button50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);

        button25 = (Button)findViewById(R.id.button25);
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMECH_TT();
            }
        });
        button27 = (Button)findViewById(R.id.button27);
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMECH_Syllabus();
            }
        });
        button50 = (Button)findViewById(R.id.button50);
        button50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMECH_Grades();
            }
        });
    }
    public void openMECH_TT(){
        Intent intent = new Intent(this, MECH_TT.class);
        startActivity(intent);
    }
    public void openMECH_Syllabus(){
        Intent intent = new Intent(this, MECH_Syllabus.class);
        startActivity(intent);
    }
    public void openMECH_Grades(){
        Intent intent = new Intent(this,MECH_Grades.class);
        startActivity(intent);
    }
}
