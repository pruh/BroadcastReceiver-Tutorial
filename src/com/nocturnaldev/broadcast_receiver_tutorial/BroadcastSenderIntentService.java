package com.nocturnaldev.broadcast_receiver_tutorial;

import android.app.IntentService;
import android.content.Intent;

public class BroadcastSenderIntentService extends IntentService {
    
    public BroadcastSenderIntentService() {
        super("BroadcastSenderIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String message = getString(R.string.lbl_running);
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.MESSAGE_SENT_ACTION);
        broadcastIntent.putExtra(MainActivity.MESSAGE_EXTRA, message);
        sendBroadcast(broadcastIntent);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        message = getString(R.string.lbl_finished);
        broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.MESSAGE_SENT_ACTION);
        broadcastIntent.putExtra(MainActivity.MESSAGE_EXTRA, message);
        sendBroadcast(broadcastIntent);
    }

}
