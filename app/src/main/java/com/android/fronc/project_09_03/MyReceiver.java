package com.android.fronc.project_09_03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private Handler handler = new Handler();

    @Override
    public void onReceive(final Context context, Intent intent) {

        if ("com.android.fronc.project_09_01".equals(intent.getAction())) {
            String message = intent.getStringExtra("com.android.fronc.project_09_01.EXTRA_MESSAGE_TEXT");
            Toast.makeText(context, "Broadcast detected Project_09_03 (" + message + ")", Toast.LENGTH_LONG).show();

            if (message.equals("sendBroadcastOrdered")) {
                Bundle results = getResultExtras(true);
                final String initialString = results.getString("INITIAL_STRING");

                handler.postDelayed(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "Initial extras: " + initialString, Toast.LENGTH_LONG).show();
                    }
                }, 24000);

                final String feedbackString = initialString + "Project_09_03;";
                results.putString("FEEDBACK_STRING", feedbackString);

                handler.postDelayed(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "Send feedback string: " + feedbackString, Toast.LENGTH_LONG).show();
                    }
                }, 32000);
            }
        }
    }
}
