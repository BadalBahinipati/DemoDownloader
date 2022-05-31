package com.example.demodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteFile extends AppCompatActivity {
    Button write;
    Button read;
    EditText txt;
    String filename;
    TextView fileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_file);

        write = (Button) findViewById(R.id.write);
        read = (Button) findViewById(R.id.read);
        txt = (EditText) findViewById(R.id.text);
        fileContent = (TextView) findViewById(R.id.content);
        filename = "TestFile.txt";

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(v);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read(v);
            }
        });
    }
    public void write(View v){
        try {
            String text = txt.getText().toString();
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.flush();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        txt.setText("This is test file...");
        Toast.makeText(WriteFile.this, "Creating file...", Toast.LENGTH_SHORT).show();
    }

    public void read(View v){
        try{
            FileInputStream fis = openFileInput(filename);
            int x;
            StringBuilder sb = new StringBuilder();
            while((x = fis.read()) != -1){
                sb.append((char)x);
            }
            fileContent.setText((sb.toString()));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Toast.makeText(WriteFile.this, "Loading your file...", Toast.LENGTH_SHORT).show();
    }
}