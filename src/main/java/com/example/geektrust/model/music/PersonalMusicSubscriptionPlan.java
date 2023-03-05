package com.example.geektrust.model.music;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;

public class PersonalMusicSubscriptionPlan extends SubscriptionPlan {

    public PersonalMusicSubscriptionPlan() {

        super.category = SubscriptionCategoryName.MUSIC;
        super.name = SubscriptionPlanName.PERSONAL;
        super.validity = StaticConstantValue.PERSONAL_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS;
        super.price = StaticConstantValue.PERSONAL_MUSIC_SUBSCRIPTION_PLAN_PRICE;
    }

}
