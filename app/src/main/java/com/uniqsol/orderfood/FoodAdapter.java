package com.uniqsol.orderfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uniqsol.orderfood.FoodItem;
import com.uniqsol.orderfood.R;

import org.w3c.dom.Text;

import java.util.List;

class FoodAdapter extends BaseAdapter
{
    List<FoodItem> l;
    Context c;

    List<FoodItem> cart;


    public FoodAdapter(Context c,List<FoodItem> l,List<FoodItem> cart)
    {
        this.l=l;
        this.c=c;
        this.cart=cart;


    }
    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.custom_listview,null);
        TextView tv1=(TextView)v.findViewById(R.id.item);
        TextView tv2=(TextView)v.findViewById(R.id.cost);
        Button b=v.findViewById(R.id.button);

        tv1.setText(l.get(position).getName());
        tv2.setText(Integer.toString(l.get(position).getCost()));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(cart.contains(l.get(position)))
                    l.get(position).incrPcs();
                else
                    cart.add(l.get(position));

                Toast.makeText(c,l.get(position).getName()+" was added to cart",Toast.LENGTH_SHORT).show();

        }});

        return v;
    }
}