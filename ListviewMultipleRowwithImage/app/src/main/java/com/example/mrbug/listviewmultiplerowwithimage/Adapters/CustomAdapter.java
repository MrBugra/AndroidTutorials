package com.example.mrbug.listviewmultiplerowwithimage.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrbug.listviewmultiplerowwithimage.AppClasses.Food;
import com.example.mrbug.listviewmultiplerowwithimage.R;

import java.util.List;

/**
 * Created by MrBug on 14.11.2017.
 */

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater inf;
    private List<Food> foodsList;

    public CustomAdapter(Activity act,List<Food> flist) {
    //inflater and list
    inf = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    foodsList = flist;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }


    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //create view from inflateService
        View foodView;
        foodView=inf.inflate(R.layout.listviewpattern,null);
        //initialize component
        TextView txtName = (TextView)foodView.findViewById(R.id.name);
        TextView txtDescreption = (TextView)foodView.findViewById(R.id.description);
        ImageView imgFood = (ImageView)foodView.findViewById(R.id.img);
        //which index in list
        Food food = foodsList.get(position);
        //setting data
        txtName.setText(food.getName());
        txtDescreption.setText(food.getDescription());
        imgFood.setImageResource(food.getDrawableId());

        return foodView;
    }
}
