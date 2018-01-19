package com.example.kamranchaudhary.odabba;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class payment extends AppCompatActivity {

    Button confirmBtn,paymentBtn1,paymentBtn2,paymentBtn3;
    final int height = 900;
    int minHeight;
    CardView payemtnCardView;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payemtnCardView = (CardView) findViewById(R.id.Payment_cardview);
        paymentBtn1 = (Button) findViewById(R.id.Payment_btn1);
        paymentBtn2 = (Button) findViewById(R.id.Payment_btn2);
        paymentBtn3 = (Button) findViewById(R.id.Payment_btn3);
        ll = (LinearLayout) findViewById(R.id.Payment_includeLayout);


        paymentBtn1.setBackground(getResources().getDrawable(R.drawable.my_btn_onclick));
        paymentBtn1.setTextColor(Color.WHITE);
        paymentBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColorDefault(paymentBtn2,paymentBtn3);
                paymentBtn1.setBackground(getResources().getDrawable(R.drawable.my_btn_onclick));
                paymentBtn1.setTextColor(Color.WHITE);
                collapseView();
                ll.removeAllViews();
            }
        });

        payemtnCardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                payemtnCardView.getViewTreeObserver().removeOnPreDrawListener(this);
                minHeight = payemtnCardView.getHeight();
                ViewGroup.LayoutParams layoutParams = payemtnCardView.getLayoutParams();
                layoutParams.height = minHeight;
                payemtnCardView.setLayoutParams(layoutParams);

                return true;
            }
        });

        paymentBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColorDefault(paymentBtn1,paymentBtn3);
                paymentBtn2.setBackground(getResources().getDrawable(R.drawable.my_btn_onclick));
                paymentBtn2.setTextColor(Color.WHITE);
                toggleCardViewnHeight(height);
            }
        });

        paymentBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColorDefault(paymentBtn1,paymentBtn2);
                paymentBtn3.setBackground(getResources().getDrawable(R.drawable.my_btn_onclick));
                paymentBtn3.setTextColor(Color.WHITE);
                toggleCardViewnHeight(height);
            }
        });

        confirmBtn = (Button) findViewById(R.id.Payment_confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(payment.this,SelectDishes.class);
                startActivity(i);
            }
        });
    }
    private void toggleCardViewnHeight(int height) {

        if (payemtnCardView.getHeight() == minHeight) {
            expandView(height);
            createEditTexts();
        } else {
            //collapseView();
        }
    }
    public void collapseView() {

        ValueAnimator anim = ValueAnimator.ofInt(payemtnCardView.getMeasuredHeightAndState(),
                minHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = payemtnCardView.getLayoutParams();
                layoutParams.height = val;
                payemtnCardView.setLayoutParams(layoutParams);

            }
        });
        anim.start();
    }
    public void expandView(int height) {

        ValueAnimator anim = ValueAnimator.ofInt(payemtnCardView.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = payemtnCardView.getLayoutParams();
                layoutParams.height = val;
                payemtnCardView.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }
    public void createEditTexts(){

        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Typeface tf = Typeface.create("Roboto bold",Typeface.BOLD);

        EditText ed1 = new EditText(payment.this);
        ed1.setLayoutParams(lparams);
        ed1.setEms(15);
        ed1.setHint("Card No.");
        ed1.setTextSize(15);
        ed1.setTypeface(tf);

        EditText ed2 = new EditText(payment.this);
        ed2.setLayoutParams(lparams);
        ed2.setEms(15);
        ed2.setHint("VC No.");
        ed2.setTextSize(15);
        ed2.setTypeface(tf);

        EditText ed3 = new EditText(payment.this);
        ed3.setLayoutParams(lparams);
        ed3.setEms(15);
        ed3.setHint("Expiry Date");
        ed3.setTextSize(15);
        ed3.setTypeface(tf);

        ll.addView(ed1);
        ll.addView(ed2);
        ll.addView(ed3);
    }
    public void changeColorDefault(Button btn1, Button btn2){
        btn1.setBackground(getResources().getDrawable(R.drawable.my_btn_border));
        btn1.setTextColor(getResources().getColor(R.color.odabba_color_main));
        btn2.setBackground(getResources().getDrawable(R.drawable.my_btn_border));
        btn2.setTextColor(getResources().getColor(R.color.odabba_color_main));
    }
}
