package com.example.geektrust.model;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;

public class SubscriptionPlan {

    protected SubscriptionCategoryName category;
    protected SubscriptionPlanName name;
    protected int validity; // in months
    protected int price;

    public int getValidity(){
        return this.validity;
    }

}
