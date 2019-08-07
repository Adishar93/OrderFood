package com.uniqsol.orderfood;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.location.*;
import android.Manifest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<FoodItem> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        cartList=new ArrayList<>();

    }



    public void openSelection(View v)
    {
        startActivity(new Intent(getApplicationContext(),SelectionMenu.class).putExtra("cart",cartList));
    }
}