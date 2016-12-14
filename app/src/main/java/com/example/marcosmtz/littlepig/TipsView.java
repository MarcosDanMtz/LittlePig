package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsView extends AppCompatActivity implements View.OnClickListener {

    private Button btnMenu;
    private Button btnAjustar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_view);

        btnAjustar = (Button) findViewById(R.id.btn_ajustar);
        btnAjustar.setOnClickListener(this);
        btnMenu= (Button) findViewById(R.id.btn_tips_menu);
        btnMenu.setOnClickListener(this);
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
}
