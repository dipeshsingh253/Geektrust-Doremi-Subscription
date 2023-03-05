package com.example.geektrust.model.factory;

import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.exception.InvalidSubscriptionPlanException;
import com.example.geektrust.model.SubscriptionPlan;
import com.example.geektrust.model.video.FreeVideoSubscriptionPlan;
import com.example.geektrust.model.video.PersonalVideoSubscriptionPlan;
import com.example.geektrust.model.video.PremiumVideoSubscriptionPlan;

public class VideoSubscriptionPlanFactory implements SubscriptionPlanFactory {
    @Override
    public SubscriptionPlan provideSubScriptionPlan(SubscriptionPlanName planName) {
        switch (planName){
            case FREE:
                return new FreeVideoSubscriptionPlan();
            case PERSONAL:
                return new PersonalVideoSubscriptionPlan();
            case PREMIUM:
                return new PremiumVideoSubscriptionPlan();
            default:
                throw new InvalidSubscriptionPlanException();
        }
    }
}
