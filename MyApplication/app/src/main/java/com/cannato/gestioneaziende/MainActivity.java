package com.cannato.gestioneaziende;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TableLayout table;
    TableRow titolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout) findViewById(R.id.tabella);
        titolo = (TableRow) findViewById(R.id.rowTitolo);

        List<String> lista = new ArrayList<String>();
        lista.add("12/03/2017;10:12;324");
        lista.add("04/02/2017;14:26;123");
        lista.add("26/01/2017;17:43;823");
        lista.add("15/02/2017;21:55;516");

        TableRow riga;
        EditText dataOra, cibo;
        for (String item : lista) {
            riga = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            riga.setLayoutParams(lp);

            String[]vett =item.split(";", 3);

            dataOra = new EditText(this);
            cibo = new EditText(this);
            dataOra.setText(vett[0] + "  " + vett[1]);
            cibo.setText(vett[2]);
            //dataOra.setWidth(0);
            //cibo.setWidth(0);
            cibo.setGravity(Gravity.CENTER);
            dataOra.setFocusable(false);
            dataOra.setClickable(false);
            cibo.setFocusable(false);
            cibo.setClickable(false);
            riga.addView(dataOra);
            riga.addView(cibo);
            table.addView(riga);
        }
        riga = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        riga.setLayoutParams(lp);
        Button aggiungi = new Button(this);
        aggiungi.setText("Aggiungi");
        aggiungi.setGravity(Gravity.CENTER);
        riga.addView(aggiungi);
        table.addView(riga);

        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
