package com.example.fourthyear.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fourthyear.Cs;
import com.example.fourthyear.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginCs extends AppCompatActivity {

    EditText username , password , name;
    Button login;

    String correct_username = "FOURTH_YR_COMP";
    String correct_password = "FOURTH_YR_COMP";
    public static final String Pref_username = "FOURTH_YR_COMP";

    DatabaseReference reference ;
    uploadpdf upload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cs);

        SharedPreferences settings = getSharedPreferences(Pref_username, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(LoginCs.this, Cs.class);
            startActivity(intent);
        }

        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        upload = new uploadpdf();
        reference = FirebaseDatabase.getInstance().getReference().child("uploadpdf");

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload.setName(name.getText().toString().trim());
                reference.push().setValue(upload);
                if(TextUtils.isEmpty(username.getText().toString())  || TextUtils.isEmpty(password.getText().toString()) )
                {
                    Toast.makeText(LoginCs.this , "Incomplete inputs" , Toast.LENGTH_LONG).show();
                }

                else if(username.getText().toString().equals(correct_username))
                {
                    if(password.getText().toString().equals(correct_password))
                    {
                        SharedPreferences settings = getSharedPreferences(Pref_username,0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("logged","logged");
                        editor.commit();
                        Intent intent = new Intent(LoginCs.this , Cs.class);
                        startActivity(intent);
                    }
                }

                else
                {
                    Toast.makeText(LoginCs.this , "Invalid username/password" , Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}