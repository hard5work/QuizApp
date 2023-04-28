package com.anish.app.quizapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class NetworkHelper {

    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        boolean result = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network networkCapabilities = connectivityManager.getActiveNetwork();
            NetworkCapabilities activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities);

            if (networkCapabilities != null) {
                if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = true;
                } else if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = true;
                } else result = activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
            } else {
                result = false;
            }
        } else {
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    result = true;
                } else
                    result = false;
            }
        }

        return result;
    }
}
