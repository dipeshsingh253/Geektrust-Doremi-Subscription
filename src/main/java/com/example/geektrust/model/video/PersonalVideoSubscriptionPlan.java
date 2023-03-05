package com.example.geektrust.model.video;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PersonalVideoSubscriptionPlan extends SubscriptionPlan {

    public PersonalVideoSubscriptionPlan() {

        super.category = SubscriptionCategoryName.VIDEO;
        super.name = SubscriptionPlanName.PERSONAL;
        super.validity = StaticConstantValue.PERSONAL_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PERSONAL_VIDEO_SUBSCRIPTION_PLAN_PRICE;

    }
}
