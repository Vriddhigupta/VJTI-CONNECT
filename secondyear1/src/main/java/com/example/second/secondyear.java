package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.secondyearcivil.LoginCivil;
import com.example.secondyearcivil.SyCivil;
import com.example.secondyearcs.LoginCs;
import com.example.secondyearcs.SyCs;
import com.example.secondyearelectronics.LoginElectronics;
import com.example.secondyearelectronics.SyElectronics;
import com.example.secondyearelectronicsandtelecom.LoginExtc;
import com.example.secondyearelectronicsandtelecom.SyExtc;
import com.example.secondyearetc.LoginEtc;
import com.example.secondyearetc.SyEtc;
import com.example.secondyearit.LoginIt;
import com.example.secondyearit.SyIt;
import com.example.secondyearmech.LoginMech;
import com.example.secondyearmech.SyMech;
import com.example.secondyearprod.LoginProd;
import com.example.secondyearprod.SyProd;
import com.example.secondyeartextile.LoginText;
import com.example.secondyeartextile.SyTextile;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class secondyear extends AppCompatActivity {

    private Button civil;
    private Button cs;
    private Button electron;
    private Button extc;
    private Button etc;
    private Button it;
    private Button mech;
    private Button prod;
    private Button text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondyear);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setProjectId("secondyear-2b7bf")
                .setApplicationId("1:627888782053:android:39adec3fffd89e1e79b20c")
                .setApiKey("AIzaSyDZ0jWDWnG7EAXX-pnTRIoZ54yhqI8p9bg ")
                .build();
        FirebaseApp.initializeApp(this /* Context */, options, "secondary");
        FirebaseApp secondary = FirebaseApp.getInstance("secondary");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        civil = (Button) findViewById(R.id.civil);
        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogincivil();
            }
        });

        cs = (Button) findViewById(R.id.cs);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogincs();
            }
        });

        electron = (Button) findViewById(R.id.tronics);
        electron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginelectron();
            }
        });

        extc = (Button) findViewById(R.id.extc);
        extc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginextc();
            }
        });

        etc = (Button) findViewById(R.id.trical);
        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginetc();
            }
        });

        it = (Button) findViewById(R.id.it);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginit();
            }
        });

        mech = (Button) findViewById(R.id.mech);
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginmech();
            }
        });

        prod = (Button) findViewById(R.id.prod);
        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginprod();
            }
        });

        text = (Button) findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogintext();
            }
        });

    }

    public void openlogincivil()
    {
        Intent intent = new Intent(this, SyCivil.class);
        startActivity(intent);
    }

    public void openlogincs()
    {
        Intent intent = new Intent(this, SyCs.class);
        startActivity(intent);
    }

    public void openloginelectron()
    {
        Intent intent = new Intent(this, SyElectronics.class);
        startActivity(intent);
    }

    public void openloginextc()
    {
        Intent intent = new Intent(this, SyExtc.class);
        startActivity(intent);
    }

    public void openloginetc()
    {
        Intent intent = new Intent(this, SyEtc.class);
        startActivity(intent);
    }

    public void openloginit()
    {
        Intent intent = new Intent(this, SyIt.class);
        startActivity(intent);
    }

    public void openloginmech()
    {
        Intent intent = new Intent(this, SyMech.class);
        startActivity(intent);
    }

    public void openloginprod()
    {
        Intent intent = new Intent(this, SyProd.class);
        startActivity(intent);
    }

    public void openlogintext()
    {
        Intent intent = new Intent(this, SyTextile.class);
        startActivity(intent);
    }
}
