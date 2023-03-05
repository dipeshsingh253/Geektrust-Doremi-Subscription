package com.example.geektrust.model.video;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PremiumVideoSubscriptionPlan extends SubscriptionPlan {

    public PremiumVideoSubscriptionPlan() {

        super.category = SubscriptionCategoryName.VIDEO;
        super.name = SubscriptionPlanName.PREMIUM;
        super.validity = StaticConstantValue.PREMIUM_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PREMIUM_VIDEO_SUBSCRIPTION_PLAN_PRICE;

    }
}
