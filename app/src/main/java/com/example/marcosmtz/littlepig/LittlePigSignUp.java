package com.example.marcosmtz.littlepig;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import com.example.marcosmtz.littlepig.InfoToSave.UserInformation;
import com.example.marcosmtz.littlepig.Objects.FirebaseReferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittlePigSignUp extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignUp;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordRepeat;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    //Guardar Infor en FireBase
    private DatabaseReference databaseReference;
    //Campos a guardar en fire base como nombre
    private EditText editTextUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_pig_sign_up);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        //Para la base de datos acceder a la raiz
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if (firebaseAuth.getCurrentUser() != null){
            //abrir cuenta porque ya esta logeado (se queda el registro)
            finish();
            startActivity(new Intent (getApplicationContext(), LittlePigAdminUser.class));
        }


        progressDialog = new ProgressDialog(this);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPasswordRepeat = (EditText) findViewById(R.id.editTextPasswordRepeat);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);
        //Dato a guardar
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);

        buttonSignUp.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    private  void registerUser(){
        String email = editTextEmail.getText().toString().trim(); //Uso de trim
        String password = editTextPassword.getText().toString().trim();
        String passswordRepeat = editTextPasswordRepeat.getText().toString().trim();
        String username = editTextUserName.getText().toString().trim();


        if (!isEmailValid(email)){
            Toast.makeText(this, "Correo Invalido", Toast.LENGTH_SHORT).show();//uso de Toast
            return;
        }

        if (password.length()<=7)
        {
            Toast.makeText(this, "La contraseña debe ser mayor a 7 caracteres", Toast.LENGTH_SHORT).show();//uso de Toast
            return;
        }


        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            //campo email esta vacio
            Toast.makeText(this, "Existen campos vacios", Toast.LENGTH_SHORT).show();//uso de Toast
            //Deteniendo la funcion execution further
            return;
        }else if (!password.equals(passswordRepeat)) {
            Toast.makeText(this, "Ingrese la misma contraseña", Toast.LENGTH_SHORT).show();
            editTextPasswordRepeat.getText().clear();
            editTextPassword.getText().clear();
            return;
        }
        //Toast.makeText(LittlePigSignUp.this, "Registrando...", Toast.LENGTH_SHORT).show();
        //Pantalla Spash
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //usuario registrado completamente
                            //Se inciara su potafolio de actividad
                            //se mostrara mensaje
                            saveUserInformation();
                            Toast.makeText(LittlePigSignUp.this, "Felicidades estas registrado...", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(LittlePigSignUp.this, "Surgio un error intente mas tarde", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void saveUserInformation(){
        String fullName = editTextUserName.getText().toString().trim();

        UserInformation userInformation = new UserInformation(fullName);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        //Sin modificacion en el agregado en tiempo rela
        databaseReference.child(FirebaseReferences.USERDATA_REFERENCE).child(user.getUid()).setValue(userInformation);

        //Con cambios en tiempo real

        Toast.makeText(this, "Informacion Guardada...", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent (getApplicationContext(), LittlePigAdminUser.class));
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignUp){
            registerUser();
        }

        if (view == textViewSignin){
            startActivity(new Intent(this, LittlePigLogIn.class));
        }
    }
}
