package com.example.geektrust.service;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.enums.TopupName;
import java.time.LocalDate;

public interface DoremiSubscriptionService {

    void startSubscription(LocalDate subscriptionStartDate);

    void addSubscription(SubscriptionCategoryName categoryName, SubscriptionPlanName planName);

    void addTopup(TopupName topupName,int numberOfMonths);

    void printRenewalDetails();

}
