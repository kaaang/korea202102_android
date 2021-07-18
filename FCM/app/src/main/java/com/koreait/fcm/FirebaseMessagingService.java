package com.koreait.fcm;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{

    private static final String TAG="FirebaseMsgService";

    private String msg, title;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG,"onMessageReceived");

        title=remoteMessage.getNotification().getTitle();
        msg=remoteMessage.getNotification().getBody();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent contentIntent = PendingIntent.getActivities(this, 0, new Intent[this, MainActivity.class],0);
    }
}
