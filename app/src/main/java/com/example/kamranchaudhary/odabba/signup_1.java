package com.example.kamranchaudhary.odabba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamranchaudhary.odabba.APIs.ApiClient;
import com.example.kamranchaudhary.odabba.Interfaces.UserSignupApiInterface;
import com.example.kamranchaudhary.odabba.Models.UserSignup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup_1 extends AppCompatActivity {

    Button signupContBtn;
    TextView fname,lname,email,phone,dob,passw;
    UserSignupApiInterface userSignupApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_1);
        signupContBtn = (Button) findViewById(R.id.signup1_contBtn);

        fname = (TextView) findViewById(R.id.firstname);
        lname = (TextView) findViewById(R.id.lastname);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        dob = (TextView) findViewById(R.id.birthday);
        passw = (TextView) findViewById(R.id.password);

        final UserSignup user = new UserSignup(fname.getText().toString(),lname.getText().toString(),
                passw.getText().toString(),email.getText().toString(),phone.getText().toString(),
                dob.getText().toString());
        Log.i("user","bc" + user.toString());

        signupContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                userSignupApiInterface = ApiClient.getApiClent().create(UserSignupApiInterface.class);
//                Call<UserSignup> call = userSignupApiInterface.signupUser(user);
//                call.enqueue(new Callback<UserSignup>() {
//                    @Override
//                    public void onResponse(Call<UserSignup> call, Response<UserSignup> response) {
//                        Toast.makeText(signup_1.this,"User with "+response.body().getId()+"inserted",Toast.LENGTH_SHORT).show();
//                    }
//                    @Override
//                    public void onFailure(Call<UserSignup> call, Throwable t) {
//                        Toast.makeText(signup_1.this,"Something went wrong !",Toast.LENGTH_LONG).show();
//                        Log.i("logig",t.getMessage());
//                    }
//                });

                Intent i = new Intent(signup_1.this,signup_2.class);
                startActivity(i);
            }
        });
    }
}
