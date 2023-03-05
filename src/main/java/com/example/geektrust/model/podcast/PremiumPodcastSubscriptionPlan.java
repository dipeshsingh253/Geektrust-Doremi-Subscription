package com.example.geektrust.model.podcast;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PremiumPodcastSubscriptionPlan extends SubscriptionPlan {

    public PremiumPodcastSubscriptionPlan() {

        super.category = SubscriptionCategoryName.PODCAST;
        super.name = SubscriptionPlanName.PREMIUM;
        super.validity = StaticConstantValue.PREMIUM_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PREMIUM_PODCAST_SUBSCRIPTION_PLAN_PRICE;

    }

}
