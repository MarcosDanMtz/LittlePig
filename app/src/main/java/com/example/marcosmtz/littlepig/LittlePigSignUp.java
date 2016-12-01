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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittlePigSignUp extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignUp;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_pig_sign_up);

        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //abrir cuenta porque ya esta logeado (se queda el registro)
            finish();
            startActivity(new Intent (getApplicationContext(), LittlePigAdminUser.class));
        }

        progressDialog = new ProgressDialog(this);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);


        buttonSignUp.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    private  void registerUser(){
        String email = editTextEmail.getText().toString().trim(); //Uso de trim
        String password = editTextPassword.getText().toString().trim();


        if (!isEmailValid(email)){
            Toast.makeText(this, "Correo Invalido", Toast.LENGTH_SHORT).show();//uso de Toast
            return;
        }


        if (password.length()<=7)
        {
            Toast.makeText(this, "La contraseña debe ser mayor a 7 caracteres", Toast.LENGTH_SHORT).show();//uso de Toast
            return;
        }


        if (TextUtils.isEmpty(email)){
            //campo email esta vacio
            Toast.makeText(this, "El campo email esta vacio", Toast.LENGTH_SHORT).show();//uso de Toast
            //Deteniendo la funcion execution further
            return;
        }


        if (TextUtils.isEmpty(password)){
            //campo contraseña esta vacio
            Toast.makeText(this,"El campo contraseña esta vacio", Toast.LENGTH_SHORT ).show();
            //Deteniendo la funcion execution further
            return;
        }


        progressDialog.setMessage("Registrando");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //usuario registrado completamente
                            //Se inciara su potafolio de actividad
                            //se mostrara mensaje
                            Toast.makeText(LittlePigSignUp.this, "Resgistrado de forma corrrecta", Toast.LENGTH_SHORT).show();
                            editTextEmail.getText().clear();
                            editTextPassword.getText().clear();
                            progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), LittlePigAdminUser.class));
                        }else {
                            Toast.makeText(LittlePigSignUp.this, "Surgio un error intente mas tarde", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
