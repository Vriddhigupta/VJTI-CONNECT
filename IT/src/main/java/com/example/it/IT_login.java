package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IT_login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText name;
    private Button login;
    String correct_username= "TY_BTECH_IT";
    String correct_password= "tybtechit2020";
    public static final String PREF_USERNAME = "TY_BTECH_IT";
    DatabaseReference reference;
    uploadpdf upload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_t_login);
        SharedPreferences settings = getSharedPreferences(PREF_USERNAME,0);
        if(settings.getString("logged","").toString().equals("logged")){
            Intent intent = new Intent(IT_login.this, ITTY.class);
            startActivity(intent);
        }
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        upload= new uploadpdf();
        reference = FirebaseDatabase.getInstance().getReference().child("uploadpdf");
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload.setName(name.getText().toString().trim());
                reference.push().setValue(upload);

                if(TextUtils.isEmpty(username.getText().toString())|| TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(IT_login.this,"Empty Data Provided",Toast.LENGTH_LONG).show();
                }else if(username.getText().toString().equals(correct_username)){
                    if(password.getText().toString().equals(correct_password)){

                        openIT();

                    }
                }else{
                    Toast.makeText(IT_login.this,"Invalid Password/Username",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void openIT(){
        SharedPreferences settings = getSharedPreferences(PREF_USERNAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("logged","logged");
        editor.commit();
        Intent intent = new Intent(this, ITTY.class);
        startActivity(intent);
    }
}
