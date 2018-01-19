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

    CardView cardViewDish1,cardViewDish2;
    TextView txt1,txt2,btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dishes);

        cardViewDish1 = (CardView) findViewById(R.id.dish1cardView);
        cardViewDish2 = (CardView) findViewById(R.id.dish2cardView);

        txt1 = (TextView) findViewById(R.id.txtViewDishDescp);
        txt2 = (TextView) findViewById(R.id.txtViewDishDescp2);

        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.myanim);

        cardViewDish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewDish2.clearAnimation();
                cardViewDish1.startAnimation(an);
                txt1.setTextColor(getResources().getColor(R.color.odabba_color_main));
                txt2.setTextColor(getResources().getColor(R.color.cardview_dark_background));
                cardViewDish1.setCardElevation(20);
                cardViewDish2.setCardElevation(0);
            }
        });

        cardViewDish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //an.cancel();
                cardViewDish1.clearAnimation();
                cardViewDish2.startAnimation(an);
                txt2.setTextColor(getResources().getColor(R.color.odabba_color_main));
                txt1.setTextColor(getResources().getColor(R.color.cardview_dark_background));
                cardViewDish2.setCardElevation(20);
                cardViewDish1.setCardElevation(0);
            }
        });
    }
}