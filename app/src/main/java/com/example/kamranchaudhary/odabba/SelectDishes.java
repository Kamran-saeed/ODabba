package com.example.kamranchaudhary.odabba;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.example.kamranchaudhary.odabba.APIs.ApiClient;
import com.example.kamranchaudhary.odabba.Interfaces.MenuApiInterface;
import com.example.kamranchaudhary.odabba.Models.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectDishes extends AppCompatActivity {

    CardView cardViewDish1,cardViewDish2;
    TextView dish1Name,dish2Name,dish1Description,dish2Description,currentDate;
    private MenuApiInterface menuApiInterface;
    public List<Menu> menuList;
    Date d;String date;TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dishes);

        cardViewDish1 = (CardView) findViewById(R.id.dish1cardView);
        cardViewDish2 = (CardView) findViewById(R.id.dish2cardView);
        dish1Name = (TextView) findViewById(R.id.txtViewDish1);
        dish2Name = (TextView) findViewById(R.id.txtViewDish2);
        dish1Description = (TextView) findViewById(R.id.txtViewDish1Desc);
        dish2Description = (TextView) findViewById(R.id.txtViewDish2Desc);
        currentDate = (TextView) findViewById(R.id.menu_date);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.myanim);

        menuApiInterface = ApiClient.getApiClent().create(MenuApiInterface.class);
        Call<List<Menu>> call = menuApiInterface.getMenu();
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                menuList = response.body();
                convertDate(0);
                currentDate.setText(date);
                dish1Name.setText(menuList.get(0).getDish_name());
                dish1Description.setText(menuList.get(0).getDish_desc());
                dish2Name.setText(menuList.get(1).getDish_name());
                dish2Description.setText(menuList.get(1).getDish_desc());

                popoupTabs();
            }
            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
            }
        });

        cardViewDish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewDish2.clearAnimation();
                cardViewDish1.startAnimation(an);
                dish1Name.setTextColor(getResources().getColor(R.color.odabba_color_main));
                dish2Name.setTextColor(getResources().getColor(R.color.cardview_dark_background));
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
                dish2Name.setTextColor(getResources().getColor(R.color.odabba_color_main));
                dish1Name.setTextColor(getResources().getColor(R.color.cardview_dark_background));
                cardViewDish2.setCardElevation(20);
                cardViewDish1.setCardElevation(0);
            }
        });
    }
    public void convertDate(int index){
        d = menuList.get(index).getMenu_day();
        date = new SimpleDateFormat("E MMM dd", Locale.ENGLISH).format(d);
    }
    public void popoupTabs(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        convertDate(0);
                        currentDate.setText(date);
                        dish1Name.setText(menuList.get(0).getDish_name());
                        dish1Description.setText(menuList.get(0).getDish_desc());
                        dish2Name.setText(menuList.get(1).getDish_name());
                        dish2Description.setText(menuList.get(1).getDish_desc());
                        break;
                    case 1:
                        convertDate(2);
                        currentDate.setText(date);
                        dish1Name.setText(menuList.get(2).getDish_name());
                        dish1Description.setText(menuList.get(2).getDish_desc());
                        dish2Name.setText(menuList.get(3).getDish_name());
                        dish2Description.setText(menuList.get(3).getDish_desc());
                        break;
                    case 2:
                        convertDate(4);
                        currentDate.setText(date);
                        dish1Name.setText(menuList.get(4).getDish_name());
                        dish1Description.setText(menuList.get(4).getDish_desc());
                        dish2Name.setText(menuList.get(5).getDish_name());
                        dish2Description.setText(menuList.get(5).getDish_desc());
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}