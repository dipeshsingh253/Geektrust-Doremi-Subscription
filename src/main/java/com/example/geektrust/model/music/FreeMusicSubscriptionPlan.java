package com.example.geektrust.model.music;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class FreeMusicSubscriptionPlan extends SubscriptionPlan {

    public FreeMusicSubscriptionPlan() {

        super.category = SubscriptionCategoryName.MUSIC;
        super.name = SubscriptionPlanName.FREE;
        super.validity = StaticConstantValue.FREE_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.FREE_MUSIC_SUBSCRIPTION_PLAN_PRICE;

    }

}
