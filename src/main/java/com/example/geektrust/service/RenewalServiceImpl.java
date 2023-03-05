package com.example.geektrust.service;

import com.example.geektrust.constant.ExceptionMessage;
import com.example.geektrust.exception.SubscriptionNotFoundException;
import com.example.geektrust.model.DoremiSubscription;

public class RenewalServiceImpl implements RenewalService{

    private DoremiSubscription doremiSubscription;

    public RenewalServiceImpl(DoremiSubscription doremiSubscription) {
        this.doremiSubscription = doremiSubscription;
    }

    @Override
    public void printRenewalDetails() {

        // if subscription started date is not available or not valid or subscription not started
        if (doremiSubscription.isSubscriptionActive())
            throw new SubscriptionNotFoundException(ExceptionMessage.SUBSCRIPTIONS_NOT_FOUND);

        doremiSubscription.printRenewalDetails();

    }
}
