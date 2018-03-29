package com.example.kamranchaudhary.odabba;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.kamranchaudhary.odabba.Models.Package;

public class payment extends AppCompatActivity {

    Button confirmBtn,paymentBtn1,paymentBtn2,paymentBtn3;
    int minHeight;
    CardView payemtnCardView;
    LinearLayout ll;
    TextView packageName,packageType,packageDays,packagePrice,packageDesc;
    Package p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        packageName = (TextView) findViewById(R.id.Payment_PackageName);
        packageType = (TextView) findViewById(R.id.Payment_PackageType);
        packageDays = (TextView) findViewById(R.id.Payemnt_packageDays);
        packagePrice = (TextView) findViewById(R.id.Payemnt_packagePrice);
        packageDesc = (TextView) findViewById(R.id.Payment_packageDesc);

        if(getIntent().hasExtra("Package_Object")){

            p = (Package) getIntent().getSerializableExtra("Package_Object");
            packageName.setText(p.getPackage_name());
            packageType.setText(p.getPackage_type());
            packageDays.setText(String.valueOf(p.getPackage_duration()) + " Days");
            packagePrice.setText("Rs. " + String.valueOf(p.getPackage_price()) + "/-");
            packageDesc.setText(p.getPackage_description());
        }

        payemtnCardView = (CardView) findViewById(R.id.Payment_cardview);
        paymentBtn1 = (Button) findViewById(R.id.Payment_btn1);
        paymentBtn2 = (Button) findViewById(R.id.Payment_btn2);
        paymentBtn3 = (Button) findViewById(R.id.Payment_btn3);
        ll = (LinearLayout) findViewById(R.id.Payment_includeLayout);

//        WindowManager windowmanager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics dimension = new DisplayMetrics();
//        windowmanager.getDefaultDisplay().getMetrics(dimension);
//        height = dimension.heightPixels;
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
                toggleCardViewnHeight();
            }
        });

        paymentBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColorDefault(paymentBtn1,paymentBtn2);
                paymentBtn3.setBackground(getResources().getDrawable(R.drawable.my_btn_onclick));
                paymentBtn3.setTextColor(Color.WHITE);
                toggleCardViewnHeight();
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
    private void toggleCardViewnHeight() {

        if (payemtnCardView.getHeight() == minHeight) {
            expandView();
            createEditTexts();
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

    public void expandView() {
//        ValueAnimator anim = ValueAnimator.ofInt(payemtnCardView.getMeasuredHeightAndState(),
//                height);
//        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                int val = (Integer) valueAnimator.getAnimatedValue();
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) payemtnCardView.getLayoutParams();
//                layoutParams.height = val;
//                layoutParams.setMargins(20,20,20,100);
//                payemtnCardView.setLayoutParams(layoutParams);
//            }
//        });
//        anim.start();
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lparams.setMargins(20,20,20,100);
        payemtnCardView.setLayoutParams(lparams);
    }

    public void createEditTexts(){

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
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