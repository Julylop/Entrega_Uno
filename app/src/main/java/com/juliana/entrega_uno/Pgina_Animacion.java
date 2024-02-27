package com.juliana.entrega_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Pgina_Animacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgina_animacion);

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Pgina_Animacion.this, MainActivity.class));
                finish();
            }
        }, 9000);
    }

}