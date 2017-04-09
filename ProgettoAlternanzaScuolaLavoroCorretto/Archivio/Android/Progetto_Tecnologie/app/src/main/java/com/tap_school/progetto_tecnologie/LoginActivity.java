package com.tap_school.progetto_tecnologie;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button btnLogin, btnRegistrazione, btnModifica;
    AlertDialog.Builder messageBox;
    File file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistrazione = (Button) findViewById(R.id.btnRegistrazione);
        btnModifica = (Button) findViewById(R.id.btnModifica);
        messageBox = new AlertDialog.Builder(this);
        file = this.getFileStreamPath("Utenti.txt");//Prendo il path del file

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editUsername.getText().toString(), password=editPassword.getText().toString();
                if(username.isEmpty() || password.isEmpty())
                {
                    messageBox.setMessage("Inserisci tutti i campi per il login.");
                    messageBox.setTitle("Error");
                    messageBox.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    });
                    messageBox.setCancelable(true);
                    messageBox.create().show();
                }
                else{
                    try {
                        if (file == null || !file.exists()) {
                            //Se il file non esiste lo creo
                                file.createNewFile();
                        }
                        FileReader reader = null;
                        reader = new FileReader(file);
                        BufferedReader buffer = new BufferedReader(reader);
                        String line="";
                        String []vett;
                        while(true){
                            line = buffer.readLine();
                            if(line == null || line.equals(""))
                                break;
                            vett = line.split(";",2);
                            if(username.equals(vett[0]) && password.equals(vett[1])){
                                Intent openAggiungiActivity = new Intent(getApplicationContext(), WelcomeActivity.class);
                                startActivity(openAggiungiActivity); //faccio partire l'activity
                            }
                        }
                    }catch (IOException ex) {
                        System.err.println("Dispositivi" + " illeggibile");
                    }
                }
            }
        });

        btnRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAggiungiActivity = new Intent(getApplicationContext(), RegistrazioneModificaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", "Registrazione"); //aggiungo il nome nel bundle
                openAggiungiActivity.putExtras(bundle); //passo il bundle come extra alla nuova activity
                startActivity(openAggiungiActivity); //faccio partire l'activity
            }
        });

        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAggiungiActivity = new Intent(getApplicationContext(), RegistrazioneModificaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", "Modifica"); //aggiungo il nome nel bundle
                openAggiungiActivity.putExtras(bundle); //passo il bundle come extra alla nuova activity
                startActivity(openAggiungiActivity); //faccio partire l'activity
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode == android.view.KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder confirm = new AlertDialog.Builder(this);
            confirm.setMessage("Vuoi uscire dall'applicazione?");
            confirm.setTitle("Exit");
            confirm.setPositiveButton("Sì", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            confirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            confirm.setCancelable(true);
            confirm.create().show();
        }
        return false;
    }
}
