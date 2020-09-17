package com.example.spesuez.ui.home.magazine;

import android.content.Context;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class MagazineDownloader {
    private String magazine_name;
    private CountDownTimer countDownTimer;
    private StorageReference mStorageRef;
    private Context context;
    public MagazineDownloader(String magazine_name, CountDownTimer countDownTimer,Context context ) {
        this.context=context;
        this.magazine_name = magazine_name;
        this.countDownTimer = countDownTimer;
    }
    public void download(){
        mStorageRef=FirebaseStorage.getInstance().getReference();
       mStorageRef= mStorageRef.child("Magazines"+"/"+magazine_name+".pdf");
      final File  file = new File(context.getFilesDir()+magazine_name+".pdf");
        mStorageRef.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
            countDownTimer.start();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                file.delete();
            }
        });
    }

}
