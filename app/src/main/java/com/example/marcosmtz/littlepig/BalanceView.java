package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BalanceView extends AppCompatActivity implements View.OnClickListener{

    public static int stateUser; // 0--> G>I,

    private Button btnMenu;
    private Button btnRecomendacion;

    private String[] conclusion = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_view);

        btnMenu = (Button) findViewById(R.id.btn_balance_menu);
        btnMenu.setOnClickListener(this);
        btnRecomendacion = (Button) findViewById(R.id.btn_balance_recomendacion);
        btnRecomendacion.setOnClickListener(this);

        TextView tvConclusion = (TextView) findViewById(R.id.text_state);
        TextView tvIngresos = (TextView) findViewById(R.id.text_inTotal);
        TextView tvGastos = (TextView) findViewById(R.id.text_outTotal);
        TextView tvDiferencia = (TextView) findViewById(R.id.text_diferencia);

        float ingresos = 8500.5001f;
        float gastos = 8000.50001f;
        float diferencia = ingresos - gastos;

        tvIngresos.setText("Ingresos: $" + Float.toString(ingresos));
        tvGastos.setText("Gastos:  -  $" + Float.toString(gastos));
        tvDiferencia.setText("Total:  $" + Float.toString(diferencia));

        conclusion[0] = getResources().getString(R.string.text_con_masGasto);
        conclusion[1] = getResources().getString(R.string.text_con_igual);
        conclusion[2] = getResources().getString(R.string.text_con_menosGasto);

        if (diferencia >0){
            tvConclusion.setText(conclusion[2]);
            stateUser = 2;
        }
        else if(diferencia <0){
            tvConclusion.setText(conclusion[0]);
            stateUser = 0;
        }
        else {
            tvConclusion.setText(conclusion[1]);
            stateUser = 1;
        }

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