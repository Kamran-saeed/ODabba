package com.example.kamranchaudhary.odabba.Models;

import java.util.Date;

public class Menu {
    private Date menu_day;
    private String dish_name;
    private String dish_desc;

    public Menu(){ }

    public Menu(Date menu_day, String dish_name, String dish_desc) {
        this.menu_day = menu_day;
        this.dish_name = dish_name;
        this.dish_desc = dish_desc;
    }

    public Date getMenu_day() {
        return menu_day;
    }

    public String getDish_name() {
        return dish_name;
    }

    public String getDish_desc() {
        return dish_desc;
    }
}
