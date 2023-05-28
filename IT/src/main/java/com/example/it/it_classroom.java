package com.example.it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class it_classroom extends AppCompatActivity {
    DatabaseReference reference;
    ArrayList<String> arrayList;
    EditText e1;
    ListView l1;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_t_classroom);
        e1 = (EditText)findViewById(R.id.editText);
        l1 = (ListView) findViewById(R.id.list1);
        arrayList = new ArrayList<>();
        adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        l1.setAdapter(adapter);
        reference= FirebaseDatabase.getInstance().getReference("chatrooms");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();
                while(i.hasNext()){
                    set.add(((DataSnapshot)i.next()).getKey());
                }
                arrayList.clear();
                arrayList.addAll(set);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(it_classroom.this,"No Network Connectivity",Toast.LENGTH_SHORT).show();

            }
        });
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(it_classroom.this,it_chatroom.class);
                intent.putExtra("room_name",((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }
    public void insert_data(View v){
        Map<String,Object> map = new HashMap<>();
        map.put(e1.getText().toString(),"");
        reference.updateChildren(map);
    }
}
