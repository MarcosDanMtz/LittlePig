package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IngresoAdd extends AppCompatActivity implements View.OnClickListener{

    private Button btnAgregaIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_add);

        btnAgregaIngreso = (Button) findViewById(R.id.btn_listo_ingreso);
        btnAgregaIngreso.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnAgregaIngreso) {
            finish();
            //startActivity(new Intent(this, IngresosView.class));
        }
    }
}
