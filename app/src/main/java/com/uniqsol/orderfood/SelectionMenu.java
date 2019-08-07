package com.uniqsol.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SelectionMenu extends AppCompatActivity {
    ArrayList<FoodItem> cartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_menu);
        setTitle("Selection");
        cartList=(ArrayList<FoodItem>) getIntent().getSerializableExtra("cart");
    }

    public void openSnacks(View v)
    {
        startActivity(new Intent(getApplicationContext(),Snacks.class).putExtra("cart",cartList));
    }

    public void openBeverages(View v)
    {
        startActivity(new Intent(getApplicationContext(),Beverages.class).putExtra("cart",cartList));
    }

    public void openNorthIndian(View v)
    {
        startActivity(new Intent(getApplicationContext(),NorthIndian.class).putExtra("cart",cartList));
    }

    public void openSouthIndian(View v)
    {
        startActivity(new Intent(getApplicationContext(),SouthIndian.class).putExtra("cart",cartList));
    }

    public void openChinese(View v)
    {
        startActivity(new Intent(getApplicationContext(),Chinese.class).putExtra("cart",cartList));
    }

    public void openPizzas(View v)
    {
        startActivity(new Intent(getApplicationContext(),Pizzas.class).putExtra("cart",cartList));
    }
}
