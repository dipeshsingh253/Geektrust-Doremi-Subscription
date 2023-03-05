package com.example.geektrust.model;

import com.example.geektrust.enums.TopupName;

public class TopupPlan {

    protected TopupName name;
    protected int validity; // in months

    protected int price;

    public TopupPlan(int validity) {
        this.validity = validity;
    }
}
