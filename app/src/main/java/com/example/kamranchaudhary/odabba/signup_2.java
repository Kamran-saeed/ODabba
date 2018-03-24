package com.example.kamranchaudhary.odabba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup_2 extends AppCompatActivity {

    Button signup2_doneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_2);

        signup2_doneBtn = (Button) findViewById(R.id.signup2_doneBtn);

        signup2_doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup_2.this, profile.class);
                startActivity(i);
            }
        });
    }
}
