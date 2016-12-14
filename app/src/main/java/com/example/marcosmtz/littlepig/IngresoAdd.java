package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.marcosmtz.littlepig.InfoToSave.IncomesInfo;
import com.example.marcosmtz.littlepig.Objects.FirebaseReferences;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class IngresoAdd extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private EditText editTextIncomeName;
    private EditText editTextIncomeValue;
    private EditText editTextIncomeDescripcion;
    private RadioButton radioButtonIncomeFijo;
    private RadioButton radioButtonIncomeVariable;
    private DatabaseReference databaseReference;
    private Button buttonAddIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_add);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        editTextIncomeName = (EditText) findViewById(R.id.editTextInputIncomeName);
        editTextIncomeValue = (EditText) findViewById(R.id.editTextInputIncomeName);
        editTextIncomeDescripcion = (EditText) findViewById(R.id.editTextInputIncomeDescription);
        radioButtonIncomeFijo = (RadioButton) findViewById(R.id.radioButtonIncomeFijo);
        radioButtonIncomeVariable = (RadioButton) findViewById(R.id.radioButtonIncomeVariable);
        buttonAddIncome = (Button) findViewById(R.id.buttonAddIncome);
        buttonAddIncome.setOnClickListener(this);


        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }

    }

    @Override
    public void onClick(View view) {
        if (view == buttonAddIncome) {
            RegistrerIncome ();
            finish();
            //startActivity(new Intent(this, IngresosView.class));
        }
    }

    private void RegistrerIncome (){
        String IncomeName = editTextIncomeName.getText().toString().trim();
        String ImcomeValue = editTextIncomeValue.getText().toString().trim();
        String IncomeDescription = editTextIncomeDescripcion.getText().toString().trim();
        boolean IncomeFijo = radioButtonIncomeFijo.isChecked();
        boolean IncomeVariable = radioButtonIncomeVariable.isChecked();

        if (TextUtils.isEmpty(IncomeName) || TextUtils.isEmpty(ImcomeValue))
        {
            Toast.makeText(this, "Existem campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }else if (IncomeFijo == false || IncomeVariable == false)
        {
            Toast.makeText(this, "Debe escoger el tipo de ingreso", Toast.LENGTH_LONG).show();
            return;
        }

        try{
            FirebaseUser user = firebaseAuth.getCurrentUser();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference incomeRef = database.getReference(FirebaseReferences.INCOME_REFERENCE);
            IncomesInfo income = new IncomesInfo(IncomeName, Double.parseDouble(ImcomeValue), IncomeDescription, IncomeFijo);
            incomeRef.child(user.getUid()).push().setValue(income);
            Toast.makeText(this, "Registraste un nuevo ingreso", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Error al almacenar informacion", Toast.LENGTH_LONG).show();
        }
    }
}
