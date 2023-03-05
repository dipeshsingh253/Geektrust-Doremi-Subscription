package com.example.geektrust.model;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.model.music.FreeMusicSubscriptionPlan;
import com.example.geektrust.model.music.PersonalMusicSubscriptionPlan;
import com.example.geektrust.model.podcast.FreePodcastSubscriptionPlan;
import com.example.geektrust.model.topup.FourDeviceTopupPlan;
import com.example.geektrust.model.video.PremiumVideoSubscriptionPlan;
import com.example.geektrust.utility.DateUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DoremiSubscriptionTest {

    private DoremiSubscription doremiSubscription;
    @BeforeEach
    void setUp() {
        doremiSubscription = new DoremiSubscription();
    }

    @Test
    void testGetter(){

        assertNotNull(doremiSubscription.getCategoryNameSubscriptionPlanMap());

    }

    @Test
    void testIsTopupPlanActive(){
        assertFalse(doremiSubscription.isTopupPlanActive()); // plan is not active
        doremiSubscription.setTopupPlan(new FourDeviceTopupPlan(5));
        assertTrue(doremiSubscription.isTopupPlanActive()); // plan is active
    }

    @Test
    void testIsSubscriptionStarted(){
        assertTrue(doremiSubscription.isSubscriptionStarted()); // subscription not started
        doremiSubscription.setSubscriptionStartDate(LocalDate.now());
        assertFalse(doremiSubscription.isSubscriptionStarted()); // subscription started
    }

    @Test
    void testIsCategoryPlanActive(){
        assertFalse(doremiSubscription.isCategoryPlanActive(SubscriptionCategoryName.MUSIC));
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.MUSIC,new FreeMusicSubscriptionPlan());
        assertTrue(doremiSubscription.isCategoryPlanActive(SubscriptionCategoryName.MUSIC));
    }

    @Test
    void testIsSubscriptionActive(){
        assertTrue(doremiSubscription.isSubscriptionActive());
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.MUSIC,new PersonalMusicSubscriptionPlan());
        assertFalse(doremiSubscription.isSubscriptionActive());
    }


    @Test
    void testPrintRenewalDetails(){
        doremiSubscription.setSubscriptionStartDate(DateUtility.convertStringToDate("20-02-2022"));
        doremiSubscription.setTopupPlan(new FourDeviceTopupPlan(3));
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.MUSIC, new PersonalMusicSubscriptionPlan());
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.VIDEO,new PremiumVideoSubscriptionPlan());
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.PODCAST,new FreePodcastSubscriptionPlan());

        final String expectedOutput = "RENEWAL_REMINDER MUSIC 10-03-2022\n" +
                "RENEWAL_REMINDER VIDEO 10-05-2022\n" +
                "RENEWAL_REMINDER PODCAST 10-03-2022\n" +
                "RENEWAL_AMOUNT 750\n";


        assertEquals(expectedOutput,getPrintRenewalDetailsOutput());


    }

    private String getPrintRenewalDetailsOutput(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        doremiSubscription.printRenewalDetails();

        String output = byteArrayOutputStream.toString();
        System.setOut(System.out);
        return output;
    }


}