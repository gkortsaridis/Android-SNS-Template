package com.georgekortsaridis.awssnspushnotifications;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.*;
import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobile.push.PushManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AWSMobileClient.initializeMobileClientIfNecessary(getApplicationContext());

        final PushManager pushManager = AWSMobileClient.defaultMobileClient().getPushManager();

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(final Void... params) {
                // register device first to ensure we have a push endpoint.
                pushManager.registerDevice();

                // if registration succeeded.
                if (pushManager.isRegistered()) {
                    try {
                        Log.i("ARN",pushManager.getEndpointArn());
                        Log.i("TOPICS",pushManager.getTopics().toString());

                        pushManager.setPushEnabled(true);
                        // Automatically subscribe to the default SNS topic
                        if (true) {
                            pushManager.subscribeToTopic(pushManager.getDefaultTopic());
                        }
                        return null;
                    } catch (final AmazonClientException ace) {
                        Log.e("PUSH", "Failed to change push notification status", ace);
                        return ace.getMessage();
                    }
                }
                return "Failed to register for push notifications.";
            }

            @Override
            protected void onPostExecute(final String errorMessage) {
                if (errorMessage != null) {
                    Log.d("ERROR",errorMessage);
                }
            }
        }.execute();

    }

}
