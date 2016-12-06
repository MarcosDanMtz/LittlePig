package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LittlePigAdminUser extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogOut;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_pig_admin_user);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }
        LoadName ();
        //Obtener Correo
        /*FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Bienbenido " + user.getEmail());
        buttonLogOut = (Button) findViewById(R.id.buttonLogout);
        buttonLogOut.setOnClickListener(this);*/
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

    private void LoadName (){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        DatabaseReference ref = database.getReference("UserData/" + user.getUid() + "/fullName");

        try {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);

                    textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);

                    textViewUserEmail.setText("Bienbenido " + value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //textViewUserEmail.setText("Bienbenido " + user.getEmail());
                }
            });
        }catch (Exception e){
            finish();
            startActivity(new Intent(this, LittlePigLogIn.class));
        }
    }
}
