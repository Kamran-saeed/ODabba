package com.example.kamranchaudhary.odabba;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText usernameEd,passwordEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.Login_btnLogin);

        usernameEd = (EditText) findViewById(R.id.login_edName);
        passwordEd = (EditText) findViewById(R.id.login_edPass);


        final AlertDialog.Builder dialog_close = new AlertDialog.Builder(Login.this);
        dialog_close.setTitle("Alert!");
        dialog_close.setMessage("Login Credantials Failed");
        dialog_close.setCancelable(false);
        dialog_close.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        });
        dialog_close.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEd.getText().toString();
                String password = passwordEd.getText().toString();
                if(username.equals("admin") && password.equals("123")){
                    Intent i = new Intent(Login.this,profile.class);
                    startActivity(i);
                }else{
                    AlertDialog dialog_showable = dialog_close.create();
                    dialog_showable.show();
                }
                //overridePendingTransition(R.anim.fadein,R.anim.myanim);
            }
        });
    }
}