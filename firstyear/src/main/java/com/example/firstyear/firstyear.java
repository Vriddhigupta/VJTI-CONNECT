package com.example.firstyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.batch1.Batch1;
import com.example.batch2.Batch2;
import com.example.batch3.Batch3;
import com.example.batch4.Batch4;
import com.example.batch5.Batch5;
import com.example.batch6.Batch6;
public class firstyear extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstyear);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch1();
            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch2();
            }

        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch3();
            }

        });
        Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch4();
            }

        });

        Button button42 = (Button) findViewById(R.id.button42);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch5();
            }

        });

        Button button82 = (Button) findViewById(R.id.button82);
        button82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbatch6();
            }

        }); }

    public void openbatch1() {
        Intent intent = new Intent(this, Batch1.class);

        startActivity(intent);
    }

    public void openbatch2() {
        Intent intent = new Intent(this, Batch2.class);

        startActivity(intent);
    }

    public void openbatch3() {
        Intent intent = new Intent(this, Batch3.class);

        startActivity(intent);
    }

    public void openbatch4() {
        Intent intent = new Intent(this, Batch4.class);

        startActivity(intent);
    }

    public void openbatch5() {
        Intent intent = new Intent(this, Batch5.class);

        startActivity(intent);
    }
    public void openbatch6() {
        Intent intent = new Intent(this, Batch6.class);

        startActivity(intent);
    }
}