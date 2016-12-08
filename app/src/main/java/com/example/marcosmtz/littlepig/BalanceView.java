package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BalanceView extends AppCompatActivity implements View.OnClickListener{

    private Button btnMenu;
    private Button btnRecomendacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_view);

        btnMenu = (Button) findViewById(R.id.btn_balance_menu);
        btnMenu.setOnClickListener(this);
        btnRecomendacion = (Button) findViewById(R.id.btn_balance_recomendacion);
        btnRecomendacion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view == btnRecomendacion) {
            //finish();
            startActivity(new Intent(this, TipsView.class));
        }
        else if (view == btnMenu){
            finish();
            //startActivity(new Intent(this, LittlePigAdminUser.class));
        }
    }
}
