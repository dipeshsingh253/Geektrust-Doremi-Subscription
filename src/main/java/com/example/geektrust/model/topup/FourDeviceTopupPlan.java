package com.example.geektrust.model.topup;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.model.TopupPlan;

public class FourDeviceTopupPlan extends TopupPlan {

    public FourDeviceTopupPlan(int numberOfMonths) {
        super(numberOfMonths);
        super.name = TopupName.FOUR_DEVICE;
        super.price = StaticConstantValue.FOUR_DEVICE_TOPUP_PLAN_PRICE_PER_MONTH;
    }
}
