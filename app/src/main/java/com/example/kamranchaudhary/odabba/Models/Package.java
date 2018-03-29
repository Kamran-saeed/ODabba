package com.example.kamranchaudhary.odabba.Models;

import java.io.Serializable;

public class Package implements Serializable {

    private int package_id;
    private String package_name;
    private String package_type;
    private int package_price;
    private int package_duration;
    private String package_description;

    public Package() { }

    public Package(int package_id, String package_name, String package_type, int package_price, int package_duration, String package_description) {

        this.package_id = package_id;
        this.package_name = package_name;
        this.package_type = package_type;
        this.package_price = package_price;
        this.package_duration = package_duration;
        this.package_description = package_description;
    }

    public int getPackage_id() {
        return package_id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getPackage_type() {
        return package_type;
    }

    public int getPackage_price() {
        return package_price;
    }

    public int getPackage_duration() {
        return package_duration;
    }

    public String getPackage_description() {
        return package_description;
    }
}
