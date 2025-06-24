package com.tumme.monpremierprogrammealisep;

import java.util.ArrayList;

public class QuizManager {
    private ArrayList<Question> questions;
    private int currentIndex = 0;
    private int score = 0;

    public QuizManager() {
        questions = new ArrayList<>();
        questions.add(new Question("Quelle est la capitale de la France ?",
                new String[]{"Marseille", "Paris", "Montpellier"},
                1)
        );

        questions.add(new Question("Combien font 9 x 7 ?",
                new String[]{"63", "72", "81"},
                0));
    }

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public boolean checkAnswer(int index) {
        if (index == getCurrentQuestion().getCorrectIndex()) {
            score++;
            return true;
        }
        return false;
    }

    public boolean nextQuestion() {
        if (currentIndex + 1 < questions.size()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public int getScore() { return score; }
    public int getTotalQuestions() { return questions.size(); }
}
