package com.example.heratale_app;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 * TODO: Might need to add more to fully be able to communicate with network connectivity
 * helper methods.
 */
public class InternetConnectionService extends IntentService {

    public InternetConnectionService() {
        super("InternetConnectionService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean isNetworkConnected = extras.getBoolean("isNetworkConnected");
        // Whatever other information we need to get from the servicee
    }

}