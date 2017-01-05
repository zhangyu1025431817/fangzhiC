package com.fangzhic.app.bean;

/**
 * Created by smacr on 2017/1/4.
 */

public class ProductCategory {
    private String name;

    public ProductCategory(){}
    public ProductCategory(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
