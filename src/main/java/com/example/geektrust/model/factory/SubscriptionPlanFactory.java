package com.example.geektrust.model.factory;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.exception.InvalidSubscriptionCategoryException;
import com.example.geektrust.model.SubscriptionPlan;

public interface SubscriptionPlanFactory {

    SubscriptionPlan provideSubScriptionPlan(SubscriptionPlanName subscriptionPlanName);

    public static SubscriptionPlanFactory provideSubscriptionPlanFactory(SubscriptionCategoryName categoryName){
        switch (categoryName){
            case MUSIC:
                return new MusicSubscriptionPlanFactory();
            case VIDEO:
                return new VideoSubscriptionPlanFactory();
            case PODCAST:
                return new PodcastSubsciptionPlanFactory();
            default:
                throw new InvalidSubscriptionCategoryException();
        }
    }

}
