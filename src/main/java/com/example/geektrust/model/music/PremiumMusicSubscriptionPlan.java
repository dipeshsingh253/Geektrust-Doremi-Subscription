package com.example.geektrust.model.music;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PremiumMusicSubscriptionPlan extends SubscriptionPlan {

    public PremiumMusicSubscriptionPlan() {

        super.category = SubscriptionCategoryName.MUSIC;
        super.name = SubscriptionPlanName.PREMIUM;
        super.validity = StaticConstantValue.PREMIUM_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PREMIUM_MUSIC_SUBSCRIPTION_PLAN_PRICE;

    }
}
