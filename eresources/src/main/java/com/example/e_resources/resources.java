package com.example.e_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class
resources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

    }
    public void goto_btech(View view)
    {
        Intent intent=new Intent(this,btech.class);
        startActivity(intent); }
}
