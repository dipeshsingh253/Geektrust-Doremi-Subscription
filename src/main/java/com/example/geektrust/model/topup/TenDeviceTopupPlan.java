package com.example.geektrust.model.topup;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.model.TopupPlan;

public class TenDeviceTopupPlan extends TopupPlan {

    public TenDeviceTopupPlan(int numberOfMonths) {
        super(numberOfMonths);
        super.name = TopupName.TEN_DEVICE;
        super.price = StaticConstantValue.TEN_DEVICE_TOPUP_PLAN_PRICE_PER_MONTH;
    }
}
