package com.example.marcosmtz.littlepig;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittlePigLogIn extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_pig_log_in);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //abrir cuenta porque ya esta logeado (se queda el registro)
            finish();
            startActivity(new Intent (getApplicationContext(), LittlePigAdminUser.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);
        buttonSignIn = (Button) findViewById(R.id.buttonSignUp);

        progressDialog = new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }

    private void  userLogin(){
        String email = editTextEmail.getText().toString().trim();
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

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            //iniciar su sesion y el aplicativo
                            finish();
                            startActivity(new Intent (getApplicationContext(), LittlePigAdminUser.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view==buttonSignIn){
            userLogin();
        }

        if (view==textViewSignUp){
            //finish();
            startActivity(new Intent(this, LittlePigSignUp.class));
        }
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
}
