package com.example.fourthyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fourthyear.ui.login.LoginCs;

public class fourthyear extends AppCompatActivity {

    private Button cs;
    private Button it;
    private Button ex;
    private Button Mech;
    private Button e;
    private Button el;
    private Button ci;
    private Button pr;
    private Button te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthyear);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cs = (Button) findViewById(R.id.cs);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCs();
            }
        });
        it = (Button) findViewById(R.id.it);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIt();
            }
        });
        ex = (Button)findViewById(R.id.extc);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEXTC();
            }
        });
        Mech = (Button)findViewById(R.id.mech);
        Mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMech();
            }
        });
        e = (Button)findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openE();
            }
        });
        el = (Button)findViewById(R.id.el);
        el.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEl();
            }
        });
        ci = (Button)findViewById(R.id.ci);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCI();
            }
        });
        pr = (Button)findViewById(R.id.pr);
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPR();
            }
        });
        te = (Button)findViewById(R.id.te);
        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTE();
            }
        });
    }

    public void openCs()
    {
        Intent intent = new Intent(this , Cs.class);
        startActivity(intent);
    }


    public void openIt()
    {
        Intent intent = new Intent(this , It.class);
        startActivity(intent);
    }
    public void openEXTC()
    {
        Intent intent = new Intent(this , Extc.class);
        startActivity(intent);
    }
    public void openMech()
    {
        Intent intent = new Intent(this , Mech.class);
        startActivity(intent);
    }
    public void openE()
    {
        Intent intent = new Intent(this , E.class);
        startActivity(intent);
    }
    public void openEl()
    {
        Intent intent = new Intent(this , El.class);
        startActivity(intent);
    }
    public void openCI()
    {
        Intent intent = new Intent(this , Ci.class);
        startActivity(intent);
    }
    public void openPR()
    {
        Intent intent = new Intent(this , Pr.class);
        startActivity(intent);
    }
    public void openTE()
    {
        Intent intent = new Intent(this , TE.class);
        startActivity(intent);
    }


}
