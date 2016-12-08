package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GastoAdd extends AppCompatActivity implements View.OnClickListener{

    Button btnListo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_add);

        btnListo = (Button) findViewById(R.id.btn_listo_gasto);
        btnListo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnListo) {
            finish();
            //startActivity(new Intent(this, GastosView.class));
        }
    }
}
