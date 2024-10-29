package com.example.lab1_hse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> ResultActivity;
    // String greeting = "Hello";
    TextView greetingMessage;
    Button senderGreeting;
    TextView greeting;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingMessage = findViewById(R.id.greetingMessage);
        senderGreeting = findViewById(R.id.senderFirst);
        greeting = findViewById(R.id.greeting);

        // greetingMessage.setText(greetingMessage.getText()  + " '" + greeting + "' ");


        senderGreeting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            // greetingMessage.setText(greetingMessage.getText()  + " '" + greeting.getText().toString() + "' ");
            intent.putExtra("greeting", greeting.getText().toString());
            ResultActivity.launch(intent);
        });

        ResultActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String name = data.getStringExtra("name");
                            String greetingWithName = greeting.getText().toString() + " " + name + "!";
                            greetingMessage.setText(greetingWithName);
                        }
                    }
                });
    }
}