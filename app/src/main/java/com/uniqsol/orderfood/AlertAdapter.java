package com.uniqsol.orderfood;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AlertAdapter extends BaseAdapter
{

    List<FoodItem> l;
    Context c;


    public AlertAdapter(Context c,List<FoodItem> l)
    {
        this.l=l;
        this.c=c;
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
        View v=inflater.inflate(R.layout.cutom_listview_cart,null);
        TextView tv1=(TextView)v.findViewById(R.id.item);
        TextView tv2=(TextView)v.findViewById(R.id.cost);
        Button b=(Button)v.findViewById(R.id.button);
        tv1.setText(l.get(position).getName());
        tv2.setText(Integer.toString(l.get(position).getCost())+"   "+Integer.toString(l.get(position).getPcs())+"pcs");
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(l.get(position).getPcs()>1)
                    l.get(position).dcrPcs();
                else
                l.remove(position);

                notifyDataSetChanged();

            }
        });

        return v;
    }
}
