package com.example.demodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DownloadOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_options);

        Button web = (Button) findViewById(R.id.op1);
        Button dev = (Button) findViewById(R.id.op2);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadOptions.this, WriteFile.class);
                Toast.makeText(DownloadOptions.this, "Selected option 1", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}