package com.example.notification30112021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnOpenNotify, mBtnCloseNotify;
    String CHANNEL_ID = "My Channel";

    NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnOpenNotify = findViewById(R.id.buttonOpenNotification);
        mBtnCloseNotify = findViewById(R.id.buttonCloseNotification);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mBtnOpenNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                builder.setSmallIcon(android.R.drawable.ic_menu_add);
                builder.setShowWhen(true);
                builder.setContentTitle("Ứng dụng có phiên bản mới");
                builder.setContentText("Bạn muốn cập nhật hay không?");
                builder.setPriority(NotificationCompat.PRIORITY_MAX);
                builder.setVibrate(new long[]{0, 1000, 500, 1000});
                builder.setLights(Color.RED, 5000, 5000);
                builder.setSound(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.baiso1));

                mNotificationManager.notify(1,builder.build());

            }
        });
    }
}