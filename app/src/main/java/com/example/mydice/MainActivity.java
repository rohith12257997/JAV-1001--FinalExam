package com.example.mydice;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   /* Intialised variables*/
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String test;
    int random;
    int min=1;
    int maxValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*
          Intialised array adapter and spinner
       */
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /*when any item is selected enter this method*/
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              /*  getting button id and checking for the click*/
                Button btn = findViewById(R.id.button);
                btn.setOnClickListener(new View.OnClickListener() {

                  /*  When roll button is clicked then execute this method*/
                    @Override
                    public void onClick(View v) {
                           /* making toast with the rolled number when button is clicked*/
                        Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " Sided Die Selected", Toast.LENGTH_SHORT).show();
                        test = (parent.getItemAtPosition(position)).toString();
                        maxValue = Integer.parseInt(test);

                        random = min + (int) (Math.random() * ((maxValue - min) + 1));

                        String rs = String.valueOf(random);
                        Toast.makeText(getBaseContext(), rs + " Is The Rolled Number", Toast.LENGTH_LONG).show();

                    }
                });


                }

                /*when nothing is selected this will run*/
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(getBaseContext(),"Please select something",Toast.LENGTH_SHORT).show();
            }


        });

    }
}