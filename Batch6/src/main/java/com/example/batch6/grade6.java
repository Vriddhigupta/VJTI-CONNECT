package com.example.batch6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class grade6 extends AppCompatActivity implements View.OnClickListener {
    final static int PICK_PDF_CODE = 2342;
    TextView textViewStatus;
    EditText edit;
    Button button418;
    ProgressBar progressBar;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ListView listView;
    List<Upload6> upload6List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade6);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        edit = (EditText) findViewById(R.id.edit);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        findViewById(R.id.button418).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        upload6List = new ArrayList<>();
        viewAllFiles();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Upload6 upload6 = upload6List.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(upload6.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads6");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload6 upload6 = postSnapshot.getValue(Upload6.class);
                    upload6List.add(upload6);

                }
                String[] uploads = new String[upload6List.size()];
                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = upload6List.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getPDF() {

        Intent intent = new Intent();
        intent.setType("application/pdf");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_PDF_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            if (data.getData() != null) {
                uploadFile(data.getData());
            } else {
                Toast.makeText(this, "No file choosen", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadFile(Uri data) {
        progressBar.setVisibility(View.VISIBLE);
        storageReference = firebaseStorage.getInstance().getReference();
        StorageReference ref = storageReference.child(Constants6.STORAGE_PATH_UPLOADS + System.currentTimeMillis() + ".pdf");
        ref.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @SuppressWarnings("VisibleForTests")
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressBar.setVisibility(View.GONE);
                textViewStatus.setText("File Uploaded Successfully");
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while (!uri.isComplete()) ;
                Uri url = uri.getResult();
                Upload6 upload6 = new Upload6(edit.getText().toString(), url.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(upload6);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @SuppressWarnings("VisibleForTests")
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                textViewStatus.setText((int) progress + "%Uploading...");

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button418) {
            getPDF();
        }
    }
}

