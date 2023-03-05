package com.example.geektrust.service;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.model.DoremiSubscription;
import com.example.geektrust.model.music.FreeMusicSubscriptionPlan;
import com.example.geektrust.utility.DateUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DoremiSubscriptionServiceImplTest {

    private DoremiSubscriptionService doremiSubscriptionService;
    private DoremiSubscription doremiSubscription;
    @BeforeEach
    void setUp() {

        doremiSubscription = new DoremiSubscription();
        doremiSubscriptionService = new DoremiSubscriptionServiceImpl(doremiSubscription, new RenewalServiceImpl(doremiSubscription));

    }

    @Test
    void testStartSubscription(){
        doremiSubscriptionService.startSubscription(LocalDate.now());
        assertFalse(doremiSubscription.isSubscriptionStarted());
    }

    @Test
    void testAddSubscription(){
        doremiSubscription.setSubscriptionStartDate(LocalDate.now());
        assertFalse(doremiSubscription.getCategoryNameSubscriptionPlanMap().containsKey(SubscriptionCategoryName.MUSIC));
        doremiSubscriptionService.addSubscription(SubscriptionCategoryName.MUSIC, SubscriptionPlanName.FREE);
        assertTrue(doremiSubscription.getCategoryNameSubscriptionPlanMap().containsKey(SubscriptionCategoryName.MUSIC));
        assertTrue(doremiSubscription.getCategoryNameSubscriptionPlanMap().get(SubscriptionCategoryName.MUSIC) instanceof FreeMusicSubscriptionPlan);
    }


    @Test
    void testAddTopup(){
        doremiSubscription.setSubscriptionStartDate(LocalDate.now());
        doremiSubscription.getCategoryNameSubscriptionPlanMap().put(SubscriptionCategoryName.MUSIC,new FreeMusicSubscriptionPlan());
        assertFalse(doremiSubscription.isTopupPlanActive()); // if topup plan not active
        doremiSubscriptionService.addTopup(TopupName.FOUR_DEVICE,3);
        assertTrue(doremiSubscription.isTopupPlanActive()); // if topup plan is active
    }

    @Test
    void testPrintRenewalDetails(){

        doremiSubscriptionService.startSubscription(DateUtility.convertStringToDate("20-02-2022"));
        doremiSubscriptionService.addSubscription(SubscriptionCategoryName.MUSIC,SubscriptionPlanName.PERSONAL);
        doremiSubscriptionService.addSubscription(SubscriptionCategoryName.PODCAST,SubscriptionPlanName.FREE);
        doremiSubscriptionService.addSubscription(SubscriptionCategoryName.VIDEO,SubscriptionPlanName.PREMIUM);
        doremiSubscriptionService.addTopup(TopupName.FOUR_DEVICE,3);

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

        doremiSubscriptionService.printRenewalDetails();

        String output = byteArrayOutputStream.toString();
        System.setOut(System.out);
        return output;
    }


}