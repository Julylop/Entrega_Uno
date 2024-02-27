package com.juliana.entrega_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nombreUsuario;
    Button btn1,btn2,Send,btnAlarma,btnEvento,btnLlamada;

    String Tag = "Prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUsuario = (TextView) findViewById(R.id.usuario);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        Send = findViewById(R.id.btnSend);
        btnAlarma= findViewById(R.id.btnAlarma);
        btnEvento= findViewById(R.id.btnEvento);
        btnLlamada=findViewById(R.id.btnLlamada);

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber("3184719273");
            }
        });


        btnEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent("Trabajo pendiente","Universidad", 1676982900, 1708518900);
            }
        });

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlarm("Despertar",8,30);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nombreUsuario.setText("Presionaste Iniciar sesión");}
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreUsuario.setText("Presionaste Inscríbete");
            }
        });

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarInformacion();


            }
        });


    }
    private void pasarInformacion(){
        String textoActual = nombreUsuario.getText().toString();
        String nombre= "Juliana";
        Intent pasarInfo = new Intent(this,Segunda_pagina.class);
        pasarInfo.putExtra("name",nombre);
        startActivity(pasarInfo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"Estoy en OnStart");
        /*nombreUsuario.setText("Estas en OnStart");*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"Estoy en OnResume");
        nombreUsuario.setText("Estas en OnResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag,"Estoy en OnRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"Estoy en OnPause");
        nombreUsuario.setText("Estas en OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag,"Estoy en OnStop");
        nombreUsuario.setText("Estas en OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"Estoy en OnDestroy");
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}