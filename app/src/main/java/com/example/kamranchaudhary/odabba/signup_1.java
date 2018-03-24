package com.example.kamranchaudhary.odabba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup_1 extends AppCompatActivity {

    Button signupContBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_1);

        signupContBtn = (Button) findViewById(R.id.signup1_contBtn);
        signupContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup_1.this,signup_2.class);
                startActivity(i);
            }
        });
    }
}
