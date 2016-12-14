package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TipsView extends AppCompatActivity implements View.OnClickListener {

    private Button btnMenu;
    private Button btnAjustar;
    private TextView tvTip1;
    private TextView tvTip2;
    private TextView tvTip3;

    private String[] arretips = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_view);

        btnAjustar = (Button) findViewById(R.id.btn_ajustar);
        btnAjustar.setOnClickListener(this);
        btnMenu= (Button) findViewById(R.id.btn_tips_menu);
        btnMenu.setOnClickListener(this);
        tvTip1 = (TextView) findViewById(R.id.tip1);
        tvTip2 = (TextView) findViewById(R.id.tip2);
        tvTip3 = (TextView) findViewById(R.id.tip3);

        selectTips();

    }

    @Override
    public void onClick(View view){
        if (view == btnAjustar) {
            //finish();
            startActivity(new Intent(this, GastosView.class));
        }
        else if (view==btnMenu){
            finish();
            startActivity(new Intent(this, LittlePigAdminUser.class));
        }
    }

    public void selectTips(){
        arretips[0] = getResources().getString(R.string.igual_tip1);
        arretips[1] = getResources().getString(R.string.igual_tip2);
        arretips[2] = getResources().getString(R.string.igual_tip3);
        arretips[3] = getResources().getString(R.string.masIngreso_tip1);
        arretips[4] = getResources().getString(R.string.masIngrso_tip2);
        arretips[5] = getResources().getString(R.string.masIngreso_tip3);
        arretips[6] = getResources().getString(R.string.menosIngreso_tip1);
        arretips[7] = getResources().getString(R.string.menosIngrso_tip2);
        arretips[8] = getResources().getString(R.string.menosIngreso_tip3);

        int temp3;
        int temp1;
        int temp2;

        do{
            temp1 = new Random().nextInt(8);
            temp2 = new Random().nextInt(8);
            temp3 = new Random().nextInt(8);
        }while(temp2 == temp1 || temp2 == temp3 || temp1 == temp3);

        tvTip1.setText(arretips[temp1]);
        tvTip2.setText(arretips[temp2]);
        tvTip3.setText(arretips[temp3]);
    }
}
