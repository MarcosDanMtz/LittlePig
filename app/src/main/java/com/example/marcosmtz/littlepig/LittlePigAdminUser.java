package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LittlePigAdminUser extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_pig_admin_user);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Bienbenido " + user.getEmail());

        buttonLogOut = (Button) findViewById(R.id.buttonLogout);

        buttonLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogOut){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }
    }
}
