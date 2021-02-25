package com.example.heratale_app;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Explicitly specify that which service class will handle the intent.
        ComponentName comp = new ComponentName(context.getPackageName(),
                InternetConnectionService.class.getName());
        intent.putExtra("isNetworkConnected",isConnected(context));
        context.startService(intent.setComponent(comp));
    }

    public  boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }


}