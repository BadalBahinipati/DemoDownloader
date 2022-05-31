package com.example.demodownloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DownloadOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_options);

        Button wrt = (Button) findViewById(R.id.op1);
        Button dev = (Button) findViewById(R.id.op2);

        wrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadOptions.this, WriteFile.class);
                Toast.makeText(DownloadOptions.this, "Selected option 1", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermission()){
                    //allowed
                    Intent in = new Intent(DownloadOptions.this, FileManager.class);
                    startActivity(in);
                }
                else{
                    //request permission
                    requestPermission();
                }
            }
        });
    }

    private void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(DownloadOptions.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
           Toast.makeText(DownloadOptions.this, "Allow storage access", Toast.LENGTH_SHORT).show();
        }
        else
          ActivityCompat.requestPermissions(DownloadOptions.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
        }

    private boolean checkPermission(){
        int val = ContextCompat.checkSelfPermission(DownloadOptions.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(val == PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;



    }
}