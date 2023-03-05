package com.example.geektrust.model.podcast;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class FreePodcastSubscriptionPlan extends SubscriptionPlan {

    public FreePodcastSubscriptionPlan() {
        super.category = SubscriptionCategoryName.PODCAST;
        super.name = SubscriptionPlanName.FREE;
        super.validity = StaticConstantValue.FREE_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.FREE_PODCAST_SUBSCRIPTION_PLAN_PRICE;

    }
}
