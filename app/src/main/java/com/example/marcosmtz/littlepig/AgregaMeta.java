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

import com.example.marcosmtz.littlepig.InfoToSave.GoalsInfo;
import com.example.marcosmtz.littlepig.InfoToSave.IncomesInfo;
import com.example.marcosmtz.littlepig.Objects.FirebaseReferences;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgregaMeta extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private EditText editTextGoalName;
    private EditText editTextGoalValue;
    private EditText editTextGoalTime;
    private Button buttonAddGoal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrega_meta);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        editTextGoalName = (EditText) findViewById(R.id.editTextGoalName);
        editTextGoalValue = (EditText) findViewById(R.id.editTextGoalValue);
        editTextGoalTime = (EditText) findViewById(R.id.editTextGoalTime);
        buttonAddGoal = (Button) findViewById(R.id.buttonAddGoal);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }

        buttonAddGoal.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == buttonAddGoal){
            RegisterGoal();
        }
    }

    private void RegisterGoal(){
        String goalName = editTextGoalName.getText().toString().trim();
        String goalValue = editTextGoalValue.getText().toString().trim();
        String goalTime = editTextGoalTime.getText().toString().trim();

        if (TextUtils.isEmpty(goalName) || TextUtils.isEmpty(goalValue) || TextUtils.isEmpty(goalTime))
        {
            Toast.makeText(this, "Existem campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            FirebaseUser user = firebaseAuth.getCurrentUser();
            GoalsInfo goal = new GoalsInfo(goalName, Float.parseFloat(goalValue), Float.parseFloat(goalTime));
            databaseReference.child(FirebaseReferences.GOAL_REFERENCE).child(user.getUid()).push().setValue(goal);
            Toast.makeText(this, "Registraste una nueva Meta", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(this, TeoriaIngreso.class));
        }catch (Exception e){
            Toast.makeText(this, "Error al almacenar informacion", Toast.LENGTH_LONG).show();
        }

    }


}
