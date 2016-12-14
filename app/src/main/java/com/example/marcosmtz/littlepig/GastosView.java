package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GastosView extends AppCompatActivity implements View.OnClickListener{

    Button btnSiguiente;
    Button btnAgrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_view);

        btnAgrega = (Button) findViewById(R.id.btn_agrega_gasto);
        btnAgrega.setOnClickListener(this);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente_gasto_view);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnSiguiente) {
            finish();
            startActivity(new Intent(this, BalanceView.class));
        }
        else if (view == btnAgrega){
            startActivity(new Intent(this, GastoAdd.class));
        }
    }
}
