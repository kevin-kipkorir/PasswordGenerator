package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button generateButton;
    private TextView passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateButton = findViewById(R.id.generate_button);
        passwordText = findViewById(R.id.password_text);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = generatePassword();
                passwordText.setText(password);
            }
        });
    }

    private String generatePassword() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!'@#$%^&*()_+-=";

        String allChars = uppercase + lowercase + numbers + symbols;
        Random random = new Random();
        char[] password = new char[14];

        //generating password of 14 characters randomly

        for (int i = 0; i < 14; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }

        return new String(password);
    }
}
