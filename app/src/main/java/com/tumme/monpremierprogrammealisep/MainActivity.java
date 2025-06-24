package com.tumme.monpremierprogrammealisep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button quizButton, triButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizButton = findViewById(R.id.btnQuiz);
        triButton = findViewById(R.id.btnTri);

        quizButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });

        triButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TriActivity.class);
            startActivity(intent);
        });
    }
}
