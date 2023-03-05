package com.example.geektrust.utility;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.model.music.FreeMusicSubscriptionPlan;
import com.example.geektrust.model.topup.FourDeviceTopupPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {


    @Test
    void testProvideSubscriptionPlan() {

        assertNotNull(Utility.provideSubscriptionPlan(SubscriptionCategoryName.MUSIC,SubscriptionPlanName.FREE));
        assertTrue(Utility.provideSubscriptionPlan(SubscriptionCategoryName.MUSIC, SubscriptionPlanName.FREE) instanceof FreeMusicSubscriptionPlan);

    }


    @Test
    void testProvideTopupPlan() {

        assertNotNull(Utility.provideTopupPlan(TopupName.FOUR_DEVICE,5));
        assertTrue(Utility.provideTopupPlan(TopupName.FOUR_DEVICE,3) instanceof FourDeviceTopupPlan);

    }
}