package com.example.e_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class finalyearbtech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalyearbtech);
    }

    public void goto_finalyearbtechbooks(View view)
    {
        Intent intent=new Intent(this,finalyearbtechbooks.class);
        startActivity(intent); }
    public void goto_finalyearbtechpastpapers(View view)
    {
        Intent intent=new Intent(this,finalyearbtechpastpapers.class);
        startActivity(intent); }
}
