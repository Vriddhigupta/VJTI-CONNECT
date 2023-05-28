package com.example.e_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fybtech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fybtech);
    }

    public void goto_fybtechbooks(View view)
    {
        Intent intent=new Intent(this,fybtechbooks.class);
        startActivity(intent); }
    public void goto_fybtechpastpapers(View view)
    {
        Intent intent=new Intent(this,fybtechpastpapers.class);
        startActivity(intent); }
}
