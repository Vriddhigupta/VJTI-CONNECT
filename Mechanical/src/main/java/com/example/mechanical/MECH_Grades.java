package com.example.mechanical;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class MECH_Grades extends AppCompatActivity implements View.OnClickListener{
    final static  int PICK_PDF_CODE=2342;
    TextView textViewStatus;
    EditText edit;
    Button button51;
    ProgressBar progressBar;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ListView listView;
    List<Upload5> uploadList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_e_c_h__grades);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        textViewStatus=(TextView)findViewById(R.id.textViewStatus);
        edit = (EditText)findViewById(R.id.edit);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        findViewById(R.id.button51).setOnClickListener(this);

        listView = (ListView)findViewById(R.id.listView);
        uploadList = new ArrayList<>();
      
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Upload5 upload = uploadList.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(upload.getUrl()));
                startActivity(intent);
            }
        });



        databaseReference = FirebaseDatabase.getInstance().getReference(Constants5.DATABASE_PATH_UPLOADS);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot :dataSnapshot.getChildren() ) {
                    Upload5 upload = postSnapshot.getValue(Upload5.class);
                    uploadList.add(upload);

                }
                String[] uploads = new String[uploadList.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads [i] = uploadList.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getPDF(){

        Intent intent = new Intent();
        intent.setType("application/pdf");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select File"),PICK_PDF_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_CODE && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            if(data.getData()!=null){
                uploadFile(data.getData());
            }else{
                Toast.makeText(this,"No file choosen",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void uploadFile(Uri data){
        progressBar.setVisibility(View.VISIBLE);
        storageReference = firebaseStorage.getInstance().getReference();
        StorageReference ref = storageReference.child(Constants5.STORAGE_PATH_UPLOADS + System.currentTimeMillis() + ".pdf");
        ref.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @SuppressWarnings("VisibleForTests")
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressBar.setVisibility(View.GONE);
                textViewStatus.setText("File Uploaded Successfully");
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url = uri.getResult();
                Upload5 upload = new Upload5(edit.getText().toString(),url.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(upload);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
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
        if (v.getId() == R.id.button51) {
            getPDF();
        }
    }

}


