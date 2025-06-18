package com.app1.phone;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber;
    GridLayout dialPad;
    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phoneNumber);
        dialPad = findViewById(R.id.dialPad);
        callButton = findViewById(R.id.callButton);

        // Add listeners to buttons dynamically
        for (int i = 0; i < dialPad.getChildCount(); i++) {
            Button b = (Button) dialPad.getChildAt(i);
            b.setOnClickListener(v -> {
                String current = phoneNumber.getText().toString();
                phoneNumber.setText(current + b.getText().toString());
            });
        }

        // Handle call button
        callButton.setOnClickListener(v -> {
            String number = phoneNumber.getText().toString();
            if (!number.isEmpty()) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + number));
                startActivity(dialIntent);
            }
        });
    }
}