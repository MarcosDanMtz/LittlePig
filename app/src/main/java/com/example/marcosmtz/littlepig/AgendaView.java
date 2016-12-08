package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgendaView extends AppCompatActivity implements View.OnClickListener {

    private Button btnMenu;
    private Button btnAgrega;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_view);
        btnAgrega = (Button) findViewById(R.id.btn_agrega_agenda);
        btnAgrega.setOnClickListener(this);
        btnMenu = (Button) findViewById(R.id.btn_menu_agenda);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == btnAgrega) {
            //finish();
            //cambiar por agenda add, en caso de tener tiempo suficiente.
            startActivity(new Intent(this, AhorraAdd.class));
        }
        else if( view == btnMenu){
            finish();
        }
    }
}
