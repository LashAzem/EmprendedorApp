package com.lashazem.emprendedor.Data;

import java.io.Serializable;

public class Product implements Serializable {

    public int pid;
    public String name;
    public String description;
    public String website;
    public String facebook;
    public String instagram;
    public String image_url;
    public String gallery_1;
    public String gallery_2;
    public String gallery_3;
    public String gallery_4;
    public int user_id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}