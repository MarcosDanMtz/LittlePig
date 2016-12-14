package com.example.marcosmtz.littlepig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class TeoriaAhorro extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria_ahorro);

        btnSiguiente = (Button) findViewById(R.id.btn_ahorro_siguiente);
        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnSiguiente) {
            finish();
            startActivity(new Intent(this, TeoriaMeta.class));
        }
    }
}
