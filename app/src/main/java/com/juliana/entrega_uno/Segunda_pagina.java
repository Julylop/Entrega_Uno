package com.juliana.entrega_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Segunda_pagina extends AppCompatActivity {

    TextView usuarioDos,textoAnterior;
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_segunda_pagina);
        usuarioDos = findViewById(R.id.usuarioDos);
        usuarioDos = findViewById(R.id.textoAnterior);


        String name = getIntent().getStringExtra("name");
        usuarioDos.setText(name);;
    }


}