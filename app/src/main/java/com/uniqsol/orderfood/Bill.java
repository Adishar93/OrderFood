package com.uniqsol.orderfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bill extends AppCompatActivity {
ArrayList<FoodItem> cartList;
ListView lv;
int total;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        setTitle("Final Bill");
        lv=findViewById(R.id.lv);
        cartList=(ArrayList<FoodItem>) getIntent().getSerializableExtra("cart");
        BillAdapter bill=new BillAdapter(this,cartList);
        TextView tv=findViewById(R.id.tv);
        lv.setAdapter(bill);


        total=0;
        for(FoodItem i:cartList)
        {
            total=total+(i.getPcs()*i.getCost());
        }

        tv.setText("Total amount:"+"      "+total);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog;

        builder.setTitle("Exit");
        builder.setMessage("Are you Sure you want to Exit?\n");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Bill.super.onBackPressed();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
        dialog=builder.create();
        dialog.show();
    }
    public void pay(View v)
    {
        Toast.makeText(this,"Payment Successful",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}
