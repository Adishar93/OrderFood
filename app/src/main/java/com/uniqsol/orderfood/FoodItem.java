package com.uniqsol.orderfood;

import java.io.Serializable;

public class FoodItem implements Serializable
{
    int cost,pcs;
    String name,type;

    public FoodItem(String name,int cost,String type)
    {
        this.name=name;
        this.cost=cost;
        this.type=type;
        this.pcs=1;
    }
    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public int getPcs()
    {
        return pcs;
    }

    public void incrPcs()
    {
        pcs++;

    }
    public void dcrPcs()
    {
        pcs--;
    }
}
