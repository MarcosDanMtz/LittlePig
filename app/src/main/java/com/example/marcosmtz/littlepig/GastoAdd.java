package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.marcosmtz.littlepig.InfoToSave.ExpensesInfo;
import com.example.marcosmtz.littlepig.InfoToSave.IncomesInfo;
import com.example.marcosmtz.littlepig.Objects.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GastoAdd extends AppCompatActivity implements View.OnClickListener {
    private TextView editTextExpenseName;
    private TextView editTextExpenseValue;
    private TextView editTextExpenseDescription;
    private RadioButton radioButtonExpenseFijo;
    private RadioButton radioButtonExpenseVariable;
    private Button buttonAddExpense;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_add);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        editTextExpenseName = (EditText) findViewById(R.id.editTextExpenseName);
        editTextExpenseValue = (EditText) findViewById(R.id.editTextExpenseValue);
        editTextExpenseDescription = (EditText) findViewById(R.id.editTextExpenseDescription);
        radioButtonExpenseFijo = (RadioButton) findViewById(R.id.radioButtonExpenseFijo);
        radioButtonExpenseVariable = (RadioButton) findViewById(R.id.radioButtonExpenseVariable);
        buttonAddExpense = (Button) findViewById(R.id.buttonAddExpense);
        buttonAddExpense.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }



    }

    @Override
    public void onClick(View view) {
        if (buttonAddExpense == view){
            SaveExpense();
            finish();
            //startActivity(new Intent(this, GastosView.class));
        }

    }

    private void SaveExpense(){
        String expenseName = editTextExpenseName.getText().toString().trim();
        String expenseValue = editTextExpenseValue.getText().toString().trim();
        String expenseDescription = editTextExpenseDescription.getText().toString().trim();
        boolean expenseFijo = radioButtonExpenseFijo.isChecked();

        if (TextUtils.isEmpty(expenseName) || TextUtils.isEmpty(expenseValue))
        {
            Toast.makeText(this, "Existem campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            FirebaseUser user = firebaseAuth.getCurrentUser();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference expenseRef = database.getReference(FirebaseReferences.EXPENSE_REFERENCE);
            ExpensesInfo expense = new ExpensesInfo(expenseName, Float.parseFloat(expenseValue), expenseDescription, expenseFijo);
            expenseRef.child(user.getUid()).push().setValue(expense);
            Toast.makeText(this, "Registraste un nuevo gasto", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Error al almacenar informacion", Toast.LENGTH_LONG).show();
        }

    }
}
