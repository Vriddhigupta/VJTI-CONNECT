package com.example.e_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tybtech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tybtech);
    }

    public void goto_tybtechbooks(View view)
    {
        Intent intent=new Intent(this,tybtechbooks.class);
        startActivity(intent); }
    public void goto_tybtechpastpapers(View view)
    {
        Intent intent=new Intent(this,tybtechpastpapers.class);
        startActivity(intent); }
}
