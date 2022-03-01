package com.example.notitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationChannel();
        findViewById(R.id.notiClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationMethod();
            }
        });
    }

    private void notificationMethod() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Utils.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(Utils.NOTI_TITLE)
                .setContentText(Utils.NOTI_DESC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(false);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(Utils.NOTI_ID,builder.build());

    }
    private void notificationChannel(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel
                    (Utils.CHANNEL_ID,Utils.CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(Utils.CHANNEL_Desc);
            NotificationManager managerCompat = getSystemService(NotificationManager.class);
            managerCompat.createNotificationChannel(channel);
        }
    }
}