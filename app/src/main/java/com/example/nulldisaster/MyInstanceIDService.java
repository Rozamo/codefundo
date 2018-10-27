package com.example.nulldisaster;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.iid.InstanceIDListenerService;

public class MyInstanceIDService extends InstanceIDListenerService {

    private static final String TAG = "MyInstanceIDService";

    @Override
    public void onTokenRefresh() {

        Log.i(TAG, "Refreshing GCM Registration Token");

        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
};