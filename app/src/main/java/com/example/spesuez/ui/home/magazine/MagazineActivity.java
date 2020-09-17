package com.example.spesuez.ui.home.magazine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.spesuez.FragBrepeated;
import com.example.spesuez.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;

import java.io.File;
import java.util.List;

public class MagazineActivity extends AppCompatActivity {
    private int currentApiVersion;
    String magazine_name;
    Bundle bundle;
    File  file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currentApiVersion = android.os.Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if(currentApiVersion >= Build.VERSION_CODES.KITKAT)
        {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView
                    .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
                    {

                        @Override
                        public void onSystemUiVisibilityChange(int visibility)
                        {
                            if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                            {
                                decorView.setSystemUiVisibility(flags);
                            }
                        }
                    });
        }
        startOfFragB();
        magazine_name=getIntent().getStringExtra("m_name");
        Dexter.withActivity(this).withPermissions
                (Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(
                        new BaseMultiplePermissionsListener(){
                            @Override
                            public void onPermissionsChecked(MultiplePermissionsReport report) {
                                super.onPermissionsChecked(report);
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                super.onPermissionRationaleShouldBeShown(permissions, token);
                            }
                        }).check();
        CountDownTimer countDownTimer=new MagazineTimer(1000,100);
        file = new File(this.getFilesDir()+magazine_name+".pdf");
            if(magazine_name.equals("Echo 12")||magazine_name.equals("Criterion 1")){
           countDownTimer.start();
        }else if(file.exists()){
           countDownTimer.start();
        }else {
            MagazineDownloader magazineDownloader=new MagazineDownloader(magazine_name,countDownTimer,this);
            magazineDownloader.download();
        }

    }
    public void startOfFragB(){
        FragBrepeated fragb=new FragBrepeated();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.view,fragb);
        fragmentTransaction.commit();
    }
    public void startFragC(Bundle bundle){
     PdfFrag pdfFrag=new PdfFrag();
        pdfFrag.setArguments(bundle);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        fragmentTransaction.replace(R.id.view, pdfFrag);
        fragmentTransaction.commit();
    }
   private class MagazineTimer extends CountDownTimer{
       public MagazineTimer(long millisInFuture, long countDownInterval) {
           super(millisInFuture, countDownInterval);
       }

       @Override
       public void onTick(long millisUntilFinished) {

       }

       @Override
       public void onFinish() {
           Bundle bundle=new Bundle();
           bundle.putString("magazine_name",magazine_name);
           bundle.putSerializable("file",file);
           startFragC(bundle);
       }
   }
}
