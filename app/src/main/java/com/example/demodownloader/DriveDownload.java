package com.example.demodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;

public class DriveDownload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_download);

        EditText urL = (EditText) findViewById(R.id.url);
        Button download = (Button) findViewById(R.id.download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUrl = urL.getText().toString();
                DownloadManager.Request req = new DownloadManager.Request(Uri.parse(getUrl));
                String title = URLUtil.guessFileName(getUrl, null, null);
                req.setTitle(title);
                req.setDescription("Downloading files...");
                String cookie = CookieManager.getInstance().getCookie(getUrl);
                req.addRequestHeader("cookie", cookie);
                req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                
            }
        });
    }
}