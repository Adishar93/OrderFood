package com.uniqsol.orderfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SouthIndian extends AppCompatActivity {
    ListView lv;
    ArrayList<FoodItem> cartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_indian);
        setTitle("South Indian");
        cartList=(ArrayList<FoodItem>) getIntent().getSerializableExtra("cart");

        ArrayList<FoodItem> l=new ArrayList<>();
        l.add(new FoodItem("Masala Dosa",100,"SouthIndian"));
        l.add(new FoodItem("My. Dosa",150,"SouthIndian"));
        l.add(new FoodItem("Idli",80,"SouthIndian"));
        l.add(new FoodItem("Wada",100,"SouthIndian"));
        l.add(new FoodItem("Upma",150,"SouthIndian"));
        l.add(new FoodItem("Uttapam",200,"SouthIndian"));
        FoodAdapter fa=new FoodAdapter(this,l,cartList);


        lv=(ListView)findViewById(R.id.south_indian);
        lv.setAdapter(fa);
    }

    public void openMenu(View v)
    {
        AlertDialog.Builder mbuilder=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.custom_alert_cart,null);
        Button back=view.findViewById(R.id.back);
        Button proceed=view.findViewById(R.id.proceed);
        AlertAdapter alertAdapter=new AlertAdapter(this,cartList);
        ListView lv=view.findViewById(R.id.lv);
        TextView noitem=(TextView)view.findViewById(R.id.noitem);
        lv.setAdapter(alertAdapter);


        mbuilder.setView(view);
        final AlertDialog dialog=mbuilder.create();
        if(cartList.isEmpty())
            noitem.setText("No Item");
        else
            noitem.setText("");

        dialog.show();

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Bill.class).putExtra("cart",cartList));
            }});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        createMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        switch(id)
        {
            case 0:
                startActivity(new Intent(getApplicationContext(),Snacks.class).putExtra("cart",cartList).putExtra("cart",cartList));
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(),Beverages.class).putExtra("cart",cartList).putExtra("cart",cartList));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(),NorthIndian.class).putExtra("cart",cartList).putExtra("cart",cartList));
                break;
            case 3:
                startActivity(new Intent(getApplicationContext(),Chinese.class).putExtra("cart",cartList).putExtra("cart",cartList));
                break;
            case 4:
                startActivity(new Intent(getApplicationContext(),Pizzas.class).putExtra("cart",cartList).putExtra("cart",cartList));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createMenu(Menu menu)
    {


        menu.add(0,0,0,"Light Snacks");
        menu.add(0,1,1,"Beverages");
        menu.add(0,2,2,"North Indian");
        menu.add(0,3,3,"Chinese");
        menu.add(0,4,4,"Pizzas");


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog;

        builder.setTitle("Exit");
        builder.setMessage("Are you Sure you want to Exit?\n(all items in the cart will be lost)");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
        dialog=builder.create();
        dialog.show();
    }
}



