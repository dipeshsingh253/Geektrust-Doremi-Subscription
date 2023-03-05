package com.example.geektrust.service;

import com.example.geektrust.constant.ExceptionMessage;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.exception.AddSubscriptionFailedException;
import com.example.geektrust.exception.AddTopupFailedException;
import com.example.geektrust.model.DoremiSubscription;
import com.example.geektrust.utility.Utility;

import java.time.LocalDate;

public class DoremiSubscriptionServiceImpl implements DoremiSubscriptionService{


    private final DoremiSubscription doremiSubscription;
    private final RenewalService renewalService;

    public DoremiSubscriptionServiceImpl(DoremiSubscription doremiSubscription, RenewalService renewalService) {
        this.doremiSubscription = doremiSubscription;
        this.renewalService = renewalService;
    }

    @Override
    public void startSubscription(LocalDate subscriptionStartDate) {

        doremiSubscription.setSubscriptionStartDate(subscriptionStartDate);

    }

    @Override
    public void addSubscription(SubscriptionCategoryName categoryName, SubscriptionPlanName planName) {

        // if subscription started date is not available or not valid or subscription not started
        if (doremiSubscription.isSubscriptionStarted())
            throw new AddSubscriptionFailedException(ExceptionMessage.ADD_SUBSCRIPTION_FAILED +" "+ExceptionMessage.INVALID_DATE);

        // if user already have an active plan for given category
        if(doremiSubscription.isCategoryPlanActive(categoryName))
            throw new AddSubscriptionFailedException(ExceptionMessage.ADD_SUBSCRIPTION_FAILED + " "+ ExceptionMessage.DUPLICATE_CATEGORY);

        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(categoryName, Utility.provideSubscriptionPlan(categoryName,planName));

    }

    @Override
    public void addTopup(TopupName topupName, int numberOfMonths) {

        // if subscription started date is not available or not valid or subscription not started
        if (doremiSubscription.isSubscriptionStarted())
            throw new AddTopupFailedException(ExceptionMessage.ADD_TOPUP_FAILED+" "+ExceptionMessage.INVALID_DATE);

        // no subscription plans are active
        if (doremiSubscription.isSubscriptionActive())
            throw new AddTopupFailedException(ExceptionMessage.ADD_TOPUP_FAILED+" "+ExceptionMessage.SUBSCRIPTIONS_NOT_FOUND);

        // if already a topup plan is active
        if(doremiSubscription.isTopupPlanActive())
            throw new AddTopupFailedException(ExceptionMessage.ADD_TOPUP_FAILED+" "+ExceptionMessage.DUPLICATE_TOPUP);

        doremiSubscription.setTopupPlan(Utility.provideTopupPlan(topupName,numberOfMonths));
    }

    @Override
    public void printRenewalDetails() {
        renewalService.printRenewalDetails();
    }


}
