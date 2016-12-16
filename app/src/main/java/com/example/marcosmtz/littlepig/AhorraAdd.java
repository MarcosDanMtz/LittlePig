package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class AhorraAdd extends AppCompatActivity implements View.OnClickListener{

    private Button btnGuardar;
    private EditText editTextSaveValue;
    private EditText editTextDate;
    private TextView textViewTotalSaves;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorra_add);

        editTextSaveValue = (EditText) findViewById(R.id.editTextSaveValue);
        editTextDate = (EditText) findViewById(R.id.editTextSaveDate);
        textViewTotalSaves = (TextView) findViewById(R.id.textViewTotalSaves);
        btnGuardar = (Button) findViewById(R.id.btn_ahorro_guardar);

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }

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


    private void AddSaveInfo(){
        String saveValue = editTextSaveValue.getText().toString().trim();
        String SaveDate =  editTextDate.getText().toString().trim();
        /*  // String -> Date
            SimpleDateFormat.parse(String);

            // Date -> String
            SimpleDateFormat.format(date);*/

    }


}