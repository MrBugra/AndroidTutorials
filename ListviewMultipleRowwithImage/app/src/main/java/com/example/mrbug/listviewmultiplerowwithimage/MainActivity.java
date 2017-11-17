package com.example.mrbug.listviewmultiplerowwithimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrbug.listviewmultiplerowwithimage.Adapters.CustomAdapter;
import com.example.mrbug.listviewmultiplerowwithimage.AppClasses.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView _foodListView;
    final List<Food> foods= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _foodListView = (ListView)findViewById(R.id.foodListView);


        foods.add(new Food("Beef","53 calories per 100gram",R.drawable.iconbeef));
        foods.add(new Food("Bread","265 calories per 100gram",R.drawable.iconbread));
        foods.add(new Food("French Fries","311 calories per 100gram",R.drawable.iconfrenchfries));
        foods.add(new Food("Hot Dog","290 calories per 100gram",R.drawable.iconhotdog));
        foods.add(new Food("Mushroom","28 calories per 100gram",R.drawable.iconmushroom));

        foods.add(new Food("Beef","53 calories per 100gram",R.drawable.iconbeef));
        foods.add(new Food("Bread","265 calories per 100gram",R.drawable.iconbread));
        foods.add(new Food("French Fries","311 calories per 100gram",R.drawable.iconfrenchfries));
        foods.add(new Food("Hot Dog","290 calories per 100gram",R.drawable.iconhotdog));
        foods.add(new Food("Mushroom","28 calories per 100gram",R.drawable.iconmushroom));

        foods.add(new Food("Beef","53 calories per 100gram",R.drawable.iconbeef));
        foods.add(new Food("Bread","265 calories per 100gram",R.drawable.iconbread));
        foods.add(new Food("French Fries","311 calories per 100gram",R.drawable.iconfrenchfries));
        foods.add(new Food("Hot Dog","290 calories per 100gram",R.drawable.iconhotdog));
        foods.add(new Food("Mushroom","28 calories per 100gram",R.drawable.iconmushroom));

        foods.add(new Food("Beef","53 calories per 100gram",R.drawable.iconbeef));
        foods.add(new Food("Bread","265 calories per 100gram",R.drawable.iconbread));
        foods.add(new Food("French Fries","311 calories per 100gram",R.drawable.iconfrenchfries));
        foods.add(new Food("Hot Dog","290 calories per 100gram",R.drawable.iconhotdog));
        foods.add(new Food("Mushroom","28 calories per 100gram",R.drawable.iconmushroom));

        CustomAdapter arrayAdapter = new CustomAdapter(this,foods);
        _foodListView.setAdapter(arrayAdapter);

        _foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              Food selectedFood = foods.get(position);

              String message="Name : "+selectedFood.getName()+" \nDescription : "+selectedFood.getDescription()+" \nPosition : "+position;

              Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
