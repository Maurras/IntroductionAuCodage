package com.tumme.monpremierprogrammealisep;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TriActivity extends AppCompatActivity {
    EditText inputNumbers;
    Button sortButton;
    Button returnButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trier);

        // Lier les composants à l'interface
        inputNumbers = findViewById(R.id.inputNumbers);
        sortButton = findViewById(R.id.sortButton);
        returnButton = findViewById(R.id.returnHome);
        resultText = findViewById(R.id.resultText);

        //Quand on clique sur le bouton retour à l'accueil
        returnButton.setOnClickListener(v -> {
            this.finish();
        });

        // Quand on clique sur le bouton
        sortButton.setOnClickListener(v -> {
            String userInput = inputNumbers.getText().toString();

            if (userInput.isEmpty()) {
                resultText.setText("⚠️ Tu dois d'abord entrer des nombres !");
                return;
            }

            try {
                // Séparer les nombres à partir des virgules
                String[] parts = userInput.split(",");
                int[] numbers = new int[parts.length];

                // Convertir chaque nombre en entier
                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i].trim());
                }

                // Trier les nombres
                // ✨ Tri par sélection (algorithme simple)

                // ToDo : Compléter cette partie avec le code du tri

                // Afficher le résultat trié
                StringBuilder result = new StringBuilder("✅ Nombres triés : ");
                for (int n : numbers) {
                    result.append(n).append("  ");
                }

                resultText.setText(result.toString());

            } catch (NumberFormatException e) {
                resultText.setText("⚠️ Erreur : entre uniquement des chiffres séparés par des virgules.");
            }
        });
    }
}
