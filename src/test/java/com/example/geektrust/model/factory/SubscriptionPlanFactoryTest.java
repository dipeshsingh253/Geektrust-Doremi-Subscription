package com.example.geektrust.model.factory;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.SubscriptionPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionPlanFactoryTest {


    @Test
    void testProvideSubscriptionPlanFactory(){
        assertNotNull(SubscriptionPlanFactory.provideSubscriptionPlanFactory(SubscriptionCategoryName.MUSIC));
        assertTrue(SubscriptionPlanFactory.provideSubscriptionPlanFactory(SubscriptionCategoryName.VIDEO) instanceof VideoSubscriptionPlanFactory);
        assertTrue(SubscriptionPlanFactory.provideSubscriptionPlanFactory(SubscriptionCategoryName.MUSIC) instanceof MusicSubscriptionPlanFactory);
        assertTrue(SubscriptionPlanFactory.provideSubscriptionPlanFactory(SubscriptionCategoryName.PODCAST) instanceof PodcastSubsciptionPlanFactory);
    }
}