package com.driveup.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On cache la barre de titre
        getSupportActionBar().hide();

        // On crée une sous-procédure (Handler) dans laquelle on exécute une interface
        // Runnable et un délais en milliseconde qui permet à la fin du décompte de lancer
        // une autre écran interface (Login)
        // Cette classe contient la méthode postDelayed qui prend en paramètre l'enterface Runnable et le temps en milliseconde
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Je lance l'interface de Login grâce à l'Intent initialisé avec les coordonnées de changement.
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent); // Je lance effectivement la fenêtre Login
                finish(); // Disposer de la mémoire la précédente interface.
            }
        },6000);

        //Toast.makeText(this, "Hello Anna", Toast.LENGTH_LONG).show();
    }

}