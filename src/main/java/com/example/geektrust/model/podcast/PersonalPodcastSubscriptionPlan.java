package com.example.geektrust.model.podcast;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PersonalPodcastSubscriptionPlan extends SubscriptionPlan {

    public PersonalPodcastSubscriptionPlan() {

        super.category = SubscriptionCategoryName.PODCAST;
        super.name = SubscriptionPlanName.PERSONAL;
        super.validity = StaticConstantValue.PERSONAL_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PERSONAL_PODCAST_SUBSCRIPTION_PLAN_PRICE;

    }

}
