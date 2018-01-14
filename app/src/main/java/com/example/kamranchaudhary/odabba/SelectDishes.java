package com.example.kamranchaudhary.odabba;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.badoualy.datepicker.DatePickerTimeline;

import java.util.Calendar;

public class SelectDishes extends AppCompatActivity {

    CardView cardView;
    TextView txt,btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dishes);

        cardView = (CardView) findViewById(R.id.dish1cardView);
        txt = (TextView) findViewById(R.id.txtViewDishDescp);
        btnSkip = (TextView) findViewById(R.id.selectDishSkipTxt);

        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.myanim);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.startAnimation(an);
                txt.setTextColor(getResources().getColor(R.color.odabba_color_main));
                cardView.setCardElevation(20);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectDishes.this,profile.class);
                startActivity(i);
            }
        });
    }
}