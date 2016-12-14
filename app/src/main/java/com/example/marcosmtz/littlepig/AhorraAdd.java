package com.example.marcosmtz.littlepig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AhorraAdd extends AppCompatActivity implements View.OnClickListener{

    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorra_add);
        btnGuardar = (Button) findViewById(R.id.btn_ahorro_guardar);
        btnGuardar.setOnClickListener(this);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View view){
        if (view == btnGuardar) {
            finish();
            // startActivity(new Intent(this, AgregaMeta.class));
        }
    }
}