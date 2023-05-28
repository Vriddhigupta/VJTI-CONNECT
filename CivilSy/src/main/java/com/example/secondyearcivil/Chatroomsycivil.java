package com.example.secondyearcivil;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Chatroomsycivil extends AppCompatActivity {
    EditText e1;
    TextView t1;

    Button upload;
    private String user_name,room_name;

    DatabaseReference reference;
    String temp_key;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroomsycivil);


        upload = (Button) findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatroomsycivil.this, Upload_ass.class);
                intent.putExtra("room_name", ((TextView)v).getText().toString());
                startActivity(intent);
            }
        });


        e1= (EditText)findViewById(R.id.editText2);
        t1= (TextView)findViewById(R.id.textView);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        room_name = getIntent().getExtras().get("room_name").toString();
        reference = FirebaseDatabase.getInstance().getReference().child(room_name);
        setTitle(" Room - "+room_name);


        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public void send(View v){

        Map<String,Object> map= new HashMap<String,Object>();
        temp_key = reference.push().getKey();
        reference.updateChildren(map);
        DatabaseReference child_ref = reference.child(temp_key);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("msg",e1.getText().toString());

        child_ref.updateChildren(map2).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        e1.setText("");
    }


    public void append_chat(DataSnapshot ss){
        String chat_msg;
        Iterator i = ss.getChildren().iterator();
        while(i.hasNext()){
            chat_msg = ((DataSnapshot)i.next()).getValue().toString();

            t1.append(chat_msg+System.getProperty("line.separator"));
        }
    }




}