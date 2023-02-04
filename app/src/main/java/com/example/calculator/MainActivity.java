package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";

    public static final String EMAIL_KEY = "email_key";

    public static final String PASSWORD_KEY = "password_key";

    SharedPreferences sharedpreferences;
    String email, password;

    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                if (username.equalsIgnoreCase("admin") &&
                        password.equalsIgnoreCase("admin")){
////                    Toast.makeText(getApplicationContext(), "Sukses Login", Toast.LENGTH_SHORT).show();
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("Sukses")
//                            .setMessage("Login Sukses")
//                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    Intent intent = new Intent(MainActivity.this, MainCalc.class);
//                                    startActivity(intent);
//                                }
//                            })
//                            // A null listener allows the button to dismiss the dialog and take no further action.
//                            .setNegativeButton(android.R.string.no, null)
//                            .setIcon(android.R.drawable.ic_dialog_alert)
//                            .show();
                    sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    // below two lines will put values for
                    // email and password in shared preferences.
                    editor.putString(EMAIL_KEY, txtUsername.getText().toString());
                    editor.putString(PASSWORD_KEY, txtPassword.getText().toString());

                    // to save our data with key and value.
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, MainCalc.class));
                    finish();
//                    startActivity(new Intent(MainActivity.this, MainCalc.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}