package com.example.mrbug.listviewmultiplerowwithimage.AppClasses;

/**
 * Created by MrBug on 14.11.2017.
 */

public class Food {
    public Food(String name, String description, Integer drawableId) {
        this.name = name;
        this.description = description;
        this.drawableId = drawableId;
    }

    private String name;
    private String description;
    private Integer drawableId;

    public Integer getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(Integer drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
