package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeoriaGasto extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria_gasto);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente_gasto);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnSiguiente) {
            finish();
            startActivity(new Intent(this, GastosView.class));
        }
    }
}
