package com.example.nulldisaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final Button emergency = (Button) findViewById(R.id.emergency);

    }
    public void broadcast(View view){
        Intent intent = new Intent(DashboardActivity.this, LocationActivity.class);
        startActivity(intent);
    }
    public void emerg_contacts(View view){
        Intent intent = new Intent(DashboardActivity.this, ContactActivity.class);
        startActivity(intent);
    }
}
