package com.georgekortsaridis.awssnspushnotifications;

/**
 * Created by george.kortsaridis on 24/04/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import com.google.android.gms.gcm.GcmListenerService;

/** A service that listens to GCM notifications. */
public class PushListenerService extends GcmListenerService {

    private static final String LOG_TAG = PushListenerService.class.getSimpleName();

    /**
     * Helper method to extract SNS message from bundle.
     *
     * @param data bundle
     * @return message string from SNS push notification
     */
    public static String getMessage(final Bundle data) {
        // If a push notification is sent as plain text, then the message appears in "default".
        // Otherwise it's in the "message" for JSON format.
        return data.containsKey("default") ? data.getString("default") : data.getString("message", "");
    }

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs. For Set of keys use
     * data.keySet().
     */
    @Override
    public void onMessageReceived(final String from, final Bundle data) {
        String message = getMessage(data);
        Log.d(LOG_TAG, "From: " + from);
        Log.d(LOG_TAG, "Message: " + message);

        Log.i("Data",data.toString());

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // prepare intent which is triggered if the notification is selected

        Intent intent = new Intent(this, MainActivity.class);
        // use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("Glidewell Assistant")
                .setContentText(getMessage(data))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true).build();
                //.addAction(R.drawable.icon, "Call", pIntent)
                //.addAction(R.drawable.icon, "More", pIntent)
                //.addAction(R.drawable.icon, "And more", pIntent).build();

        Log.i("/time",data.getLong("google.sent_time",0)+"");
        notificationManager.notify((int)data.getLong("google.sent_time",0), n);

        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
    }
}