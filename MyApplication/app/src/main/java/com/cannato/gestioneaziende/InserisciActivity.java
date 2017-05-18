package com.cannato.gestioneaziende;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserisciActivity extends AppCompatActivity {

    EditText denominazione, indirizzo, anno, specializzazione, classe, sezione, tirocinio, tutor, indirizzoStudente;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserisci);

        denominazione = (EditText) findViewById(R.id.editDenominazione);
        indirizzo = (EditText) findViewById(R.id.editIndirizzo);
        anno = (EditText) findViewById(R.id.editAnno);
        specializzazione = (EditText) findViewById(R.id.editSpecializzazione);
        classe = (EditText) findViewById(R.id.editClasse);
        sezione = (EditText) findViewById(R.id.editSezione);
        tirocinio = (EditText) findViewById(R.id.editTirocinio);
        tutor = (EditText) findViewById(R.id.editTutor);
        indirizzoStudente = (EditText) findViewById(R.id.editIndirizzoStudente);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InserisciActivity.this, "Azienda inserita", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
