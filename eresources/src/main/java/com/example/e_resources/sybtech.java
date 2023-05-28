package com.example.e_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sybtech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sybtech);
    }

    public void goto_sybtechbooks(View view)
    {
        Intent intent=new Intent(this,sybtechbooks.class);
        startActivity(intent); }
    public void goto_sybtechpastpapers(View view)
    {
        Intent intent=new Intent(this,sybtechpastpapers.class);
        startActivity(intent); }
}
