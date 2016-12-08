package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IngresosView extends AppCompatActivity implements View.OnClickListener{

    Button btnAgregar;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos_view);

        btnAgregar = (Button) findViewById(R.id.btn_agrega_ingreso);
        btnAgregar.setOnClickListener(this);

        btnSiguiente = (Button) findViewById(R.id.btn_listo_ingreso);
        btnSiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view == btnSiguiente){
            finish();
            startActivity(new Intent(this, TeoriaGasto.class));
        }
        else if (view == btnAgregar) {
        startActivity(new Intent(this, IngresoAdd.class));
        }
    }
}
