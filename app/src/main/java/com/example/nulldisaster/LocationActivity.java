package com.example.nulldisaster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;

public class LocationActivity extends Activity implements LocationListener {
    Button getLocationBtn;
    TextView locationText;
    EditText phone_no;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        getLocationBtn = (Button)findViewById(R.id.locationBTN);
        locationText = (TextView)findViewById(R.id.locationText);
        phone_no = (EditText) findViewById(R.id.phoneno);

        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 50, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        locationText.setText("Current Location: " + location.getLatitude() + ", " + location.getLongitude());
        String message="http://maps.google.com/maps?saddr="+location.getLatitude()+","+ location.getLongitude();
        String number = "7565858527";
        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(message));
        android.telephony.SmsManager.getDefault().sendTextMessage(number, null, smsBody.toString(), null,null);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(LocationActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    public void logout(View view){
        Intent intent = new Intent(LocationActivity.this, ToDoActivity.class);
        startActivity(intent);
    }
}