package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class
events extends AppCompatActivity {
private Button button1;
private Button button2;
private Button button3;
private Button button4;
private Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
       button1 = (Button)findViewById(R.id.button1);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               opentechno();
           }
       });
       button2 = (Button)findViewById(R.id.button2);
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openprati();
           }
       });
       button3 = (Button)findViewById(R.id.button3);
       button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openranga();
           }
       });
       button4 =(Button)findViewById(R.id.button4);
       button4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openenthusia();
           }
       });
       button5 =(Button)findViewById(R.id.button5);
       button5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openecell();
           }
       });
    }
    public void opentechno(){
        Intent intent = new Intent(this, techno.class);
        startActivity(intent);
    }
    public void openprati(){
        Intent intent = new Intent(this,prati.class);
        startActivity(intent);
    }
    public void openranga(){
        Intent intent = new Intent(this,ranga.class);
        startActivity(intent);
    }
    public void openenthusia(){
        Intent intent = new Intent(this,enthusia.class);
        startActivity(intent);
    }
    public void openecell(){
        Intent intent = new Intent(this,ecell.class);
        startActivity(intent);
    }
}
