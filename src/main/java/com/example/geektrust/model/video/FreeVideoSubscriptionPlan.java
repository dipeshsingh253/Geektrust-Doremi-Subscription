package com.example.geektrust.model.video;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class FreeVideoSubscriptionPlan extends SubscriptionPlan {

    public FreeVideoSubscriptionPlan() {

        super.category = SubscriptionCategoryName.VIDEO;
        super.name = SubscriptionPlanName.FREE;
        super.validity = StaticConstantValue.FREE_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.FREE_VIDEO_SUBSCRIPTION_PLAN_PRICE;

    }

}
