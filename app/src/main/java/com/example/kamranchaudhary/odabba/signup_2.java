package com.example.kamranchaudhary.odabba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kamranchaudhary.odabba.Models.Address;

public class signup_2 extends AppCompatActivity {

    Button signup2_doneBtn;
    TextView workspace,area,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_2);

        workspace = (TextView) findViewById(R.id.workspace);
        area = (TextView) findViewById(R.id.area);
        detail = (TextView) findViewById(R.id.detail);
        signup2_doneBtn = (Button) findViewById(R.id.signup2_doneBtn);

        Address address = new Address(workspace.getText().toString(),area.getText().toString(),detail.getText().toString());

        signup2_doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup_2.this, profile.class);
                startActivity(i);
            }
        });
    }
}
