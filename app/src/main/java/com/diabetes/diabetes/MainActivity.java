package com.diabetes.diabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button switchToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToProfile = findViewById(R.id.button_toProfile);
        switchToProfile.setOnClickListener(view -> switchActivities());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void switchActivities(){
        Intent switchActivityIntent = new Intent(this, Profile.class);
        switchActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
    }
}