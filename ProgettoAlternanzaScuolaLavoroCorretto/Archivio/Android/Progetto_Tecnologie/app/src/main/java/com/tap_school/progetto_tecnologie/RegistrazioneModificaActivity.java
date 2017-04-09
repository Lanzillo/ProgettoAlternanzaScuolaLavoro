package com.tap_school.progetto_tecnologie;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrazioneModificaActivity extends AppCompatActivity {

    String str;
    TextView textTitolo;
    Button btnConferma;
    EditText editUsername, editPassword;
    AlertDialog.Builder messageBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione_modifica);

        final Bundle bundle = this.getIntent().getExtras(); //associo il bundle agli extra di questa activity
        str = bundle.getString("nome"); //cerco la stringa name

        textTitolo = (TextView) findViewById(R.id.textTitolo);
        btnConferma = (Button) findViewById(R.id.btnConferma);
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        messageBox = new AlertDialog.Builder(this);

        textTitolo.setText(str);
        btnConferma.setText(str);

        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    messageBox.setMessage("Inserisci tutti i campi per la registrazione.");
                    messageBox.setTitle("Error");
                    messageBox.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    });
                    messageBox.setCancelable(true);
                    messageBox.create().show();
                }
                else{
                    FileOutputStream scrittore = null;
                    try {
                        scrittore = openFileOutput("Utenti.txt", MODE_APPEND);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    PrintWriter fileScrittura = new PrintWriter(scrittore);
                    fileScrittura.println(username + ";" + password);
                    fileScrittura.close();
                    try {
                        scrittore.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "Registrazione effettuata", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
