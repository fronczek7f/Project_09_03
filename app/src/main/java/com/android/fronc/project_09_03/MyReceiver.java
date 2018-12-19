package com.android.fronc.project_09_03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Handler handler = new Handler();
        Resources resources = context.getResources();

        final String message = intent.getStringExtra("com.android.fronc.project_09_01.EXTRA_MESSAGE_TEXT");
        final String appName = resources.getString(R.string.app_name);

        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);

        final String stringExtra = resultExtras.getString("stringExtra");

        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Broadcast detected " + appName + " (" + message + ")", Toast.LENGTH_LONG).show();
            }
        }, 4000);

        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "extra string: " + stringExtra, Toast.LENGTH_LONG).show();
            }
        }, 8000);

        final String stringFeedback = stringExtra + " " + appName + ";";

        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Send feedback string: " + stringFeedback, Toast.LENGTH_LONG).show();
            }
        }, 12000);

        resultData = "OR3";
        resultExtras.putString("stringExtra", stringFeedback);

        resultCode++;
        setResult(resultCode, resultData, resultExtras);
    }
}
