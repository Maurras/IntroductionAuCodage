package com.tumme.monpremierprogrammealisep;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    TextView questionText;
    RadioGroup optionsGroup;
    Button validateButton;
    QuizManager quizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        validateButton = findViewById(R.id.validateButton);
        quizManager = new QuizManager();

        displayQuestion();

        validateButton.setOnClickListener(v -> {
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                int index = optionsGroup.indexOfChild(findViewById(selectedId));
                boolean correct = quizManager.checkAnswer(index);

                String message = correct ? "Bonne réponse !" : "Mauvaise réponse...";
                new AlertDialog.Builder(this)
                        .setTitle("Résultat")
                        .setMessage(message)
                        .setPositiveButton("Suivant", (dialog, which) -> {
                            if (quizManager.nextQuestion()) {
                                displayQuestion();
                            } else {
                                showFinalScore();
                            }
                        }).show();
            }
        });
    }

    void displayQuestion() {
        Question q = quizManager.getCurrentQuestion();
        questionText.setText(q.getQuestionText());
        optionsGroup.removeAllViews();
        for (String option : q.getOptions()) {
            RadioButton rb = new RadioButton(this);
            rb.setText(option);
            optionsGroup.addView(rb);
        }
    }

    void showFinalScore() {
        new AlertDialog.Builder(this)
                .setTitle("Fin du quiz")
                .setMessage("Score : " + quizManager.getScore() + "/" + quizManager.getTotalQuestions())
                .setPositiveButton("OK", (dialog, which) -> finish())
                .show();
    }
}
