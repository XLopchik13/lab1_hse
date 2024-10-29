package com.example.lab1_hse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView greetingMessage = findViewById(R.id.greetingMessage);
        EditText nameEditText = findViewById(R.id.nameEditText);
        Button returnButton = findViewById(R.id.returnButton);

        String greeting = getIntent().getStringExtra("greeting");
        greetingMessage.setText(greetingMessage.getText() + " '"  + greeting + "' ");

        returnButton.setOnClickListener(v -> {
            String userName = nameEditText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", userName);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
