package com.driveup.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText lg_username, lg_password;
    Button bt_cancel, bt_validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialisation des récupérations de variables de l'interface Login
        lg_username = findViewById(R.id.login_username);
        lg_password = findViewById(R.id.login_password);
        bt_cancel = findViewById(R.id.login_cancel_button);
        bt_validate = findViewById(R.id.login_validate_button);

        // Evènement Clic sur bouton annuler
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lg_username.setText(null);
                lg_password.setText(null);
            }
        });
        // Evènement Clic sur bouton connexion
        bt_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lg_username.getText().toString();
                String password = lg_password.getText().toString();
                if (username == "MONKAMBULA ANNE" && password == "12345678"){
                    // On prépare une Intention d'ouverture de la fenêtre Accueil
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("name", "MONKAMBULA ANNE");
                    intent.putExtra("role", "Chef de projet");
                    startActivity(intent); // On lance l'interface Accueil grâce à l'intention préparée
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Nom d\'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}