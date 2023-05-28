package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ITTY extends AppCompatActivity {
    private Button button;
    private Button button3;
    private Button button48;
    private Button classroom;
    private Button logout;
    public static final String PREF_USERNAME="TY_BTECH_IT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itty);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIT_TT();
            }
        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIT_Syllabus();
            }
        });
        button48 =(Button)findViewById(R.id.button48);
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIT_Grades();
            }
        });
    classroom =(Button)findViewById(R.id.classroom);
    classroom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openit_classroom();
        }
    });
//    logout =(Button)findViewById(R.id.logout);
//    logout.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            SharedPreferences settings = getSharedPreferences(PREF_USERNAME,0);
//            SharedPreferences.Editor editor= settings.edit();
//            editor.remove("logged");
//            editor.commit();
//            finish();
//            Intent intent = new Intent(ITTY.this,IT_login.class);
//            startActivity(intent);
//        }
//    });
    }
    public void openIT_TT(){
        Intent intent = new Intent(this, IT_TT.class);
        startActivity(intent);
    }
    public void openIT_Syllabus(){
        Intent intent = new Intent(this, IT_Syllabus.class);
        startActivity(intent);
    }
    public void openIT_Grades(){
        Intent intent = new Intent(this, IT_Grades.class);
        startActivity(intent);
    }
    public void openit_classroom(){
        Intent intent = new Intent(this,it_classroom.class);
        startActivity(intent);
    }

}
