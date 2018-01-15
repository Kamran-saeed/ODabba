package com.example.kamranchaudhary.odabba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class payment extends AppCompatActivity {

    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirmBtn = (Button) findViewById(R.id.Payment_confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(payment.this,SelectDishes.class);
                startActivity(i);
            }
        });
    }
}
