package com.example.geektrust.model.factory;

import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.exception.InvalidSubscriptionPlanException;
import com.example.geektrust.model.SubscriptionPlan;
import com.example.geektrust.model.music.FreeMusicSubscriptionPlan;
import com.example.geektrust.model.music.PersonalMusicSubscriptionPlan;
import com.example.geektrust.model.music.PremiumMusicSubscriptionPlan;

public class MusicSubscriptionPlanFactory implements SubscriptionPlanFactory {
    @Override
    public SubscriptionPlan provideSubScriptionPlan(SubscriptionPlanName planName) {
        switch (planName){
            case FREE:
                return new FreeMusicSubscriptionPlan();
            case PERSONAL:
                return new PersonalMusicSubscriptionPlan();
            case PREMIUM:
                return new PremiumMusicSubscriptionPlan();
            default:
                throw new InvalidSubscriptionPlanException();
        }
    }
}
