package com.example.geektrust.utility;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.exception.InvalidTopupPlanException;
import com.example.geektrust.model.SubscriptionPlan;
import com.example.geektrust.model.TopupPlan;
import com.example.geektrust.model.factory.SubscriptionPlanFactory;
import com.example.geektrust.model.topup.FourDeviceTopupPlan;
import com.example.geektrust.model.topup.TenDeviceTopupPlan;


public class Utility {

    private Utility(){

    }


    public static SubscriptionPlan provideSubscriptionPlan(SubscriptionCategoryName categoryName, SubscriptionPlanName planName){

        SubscriptionPlanFactory subscriptionPlanFactory = SubscriptionPlanFactory.provideSubscriptionPlanFactory(categoryName);

        return subscriptionPlanFactory.provideSubScriptionPlan(planName);

    }

    public static TopupPlan provideTopupPlan(TopupName topupName,int numberOfMonths){
        switch (topupName){
            case FOUR_DEVICE:return new FourDeviceTopupPlan(numberOfMonths);
            case TEN_DEVICE:return new TenDeviceTopupPlan(numberOfMonths);
            default:throw new InvalidTopupPlanException();
        }
    }

}
