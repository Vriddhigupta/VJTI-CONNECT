package com.example.thirdyear;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.civil.civil;
import com.example.computer.computer;
import com.example.electrical.electrical;
import com.example.electronics.electronics;
import com.example.extc.extcty;
import com.example.it.ITTY;
import com.example.it.IT_login;
import com.example.mechanical.mechanical;
import com.example.production.production;
import com.example.textile.textile;

public class thirdyear extends AppCompatActivity {
    private Button button60;
    private Button button61;
    private Button button62;
    private Button button63;
    private Button button64;
    private Button button65;
    private Button button66;
    private Button button67;
    private Button button68;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdyear);
        button60 = (Button)findViewById(R.id.button60);
        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openit_login();
            }
        });
        button61 = (Button)findViewById(R.id.button61);
        button61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencomputer();
            }
        });
       button62 = (Button)findViewById(R.id.button62);
        button62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openextc();
            }
        });
        button63 = (Button)findViewById(R.id.button63);
        button63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openelectronics();
            }
        });
        button64 = (Button)findViewById(R.id.button64);
        button64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openelectrical();
            }
        });
        button65 = (Button)findViewById(R.id.button65);
        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmechanical();
            }
        });
        button66 = (Button)findViewById(R.id.button66);
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencivil();
            }
        });
        button67 = (Button)findViewById(R.id.button67);
        button67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openproduction();
            }
        });
        button68 = (Button)findViewById(R.id.button68);
        button68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentextile();
            }
        });
    }
    public void openit_login(){
        Intent intent = new Intent(this, ITTY.class);
        startActivity(intent);
    }
    public void opencomputer(){
        Intent intent = new Intent(this, computer.class);
        startActivity(intent);
    }
    public void openextc(){
        Intent intent = new Intent(this, extcty.class);
        startActivity(intent);
    }
    public void openelectronics(){
        Intent intent = new Intent(this, electronics.class);
        startActivity(intent);
    }
    public void openelectrical(){
        Intent intent = new Intent(this, electrical.class);
        startActivity(intent);
    }
    public void openmechanical(){
        Intent intent = new Intent(this, mechanical.class);
        startActivity(intent);
    }
    public void opencivil(){
        Intent intent = new Intent(this, civil.class);
        startActivity(intent);
    }
    public void openproduction(){
        Intent intent = new Intent(this, production.class);
        startActivity(intent);
    }
    public void opentextile(){
        Intent intent = new Intent(this, textile.class);
        startActivity(intent);
    }
}
