package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeoriaIngreso extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria_ingreso);

        btnSiguiente = (Button) findViewById(R.id.btn_siguiente_ingreso);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnSiguiente) {
            finish();
            startActivity(new Intent(this, IngresosView.class));
        }
    }
}
