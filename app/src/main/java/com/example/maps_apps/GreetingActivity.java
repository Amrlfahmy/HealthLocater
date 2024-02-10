package com.example.maps_apps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {
    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        // Retrieve the full name from the intent
        String fullName = getIntent().getStringExtra("FULL_NAME");

        // Display the greeting with the full name
        greetingTextView = findViewById(R.id.textView_greeting);
        greetingTextView.setText("Welcome, " + fullName + "\u263A");

        // Delay and then start MapsActivity
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        startActivity(new Intent(GreetingActivity.this, MapsActivity.class));
                        finish();
                    }
                },
                1000 // 1 seconds delay
        );
    }
}
