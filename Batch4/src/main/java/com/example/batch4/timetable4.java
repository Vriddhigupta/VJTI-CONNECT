package com.example.batch4;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class timetable4 extends Activity {
    Button down4;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable4);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setImageResource(R.drawable.batch4);
        down4 = findViewById(R.id.down4);
        down4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
    }
    public void download()
    {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("batch4.jpg");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {


            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(timetable4.this,"batch4.jpg", ".jpg", (String) DIRECTORY_DOWNLOADS ,  url );

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url)



    {



        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);


        downloadManager.enqueue(request);



    }
    }
