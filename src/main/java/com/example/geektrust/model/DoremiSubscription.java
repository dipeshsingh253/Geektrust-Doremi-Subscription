package com.example.geektrust.model;

import com.example.geektrust.constant.ProgramMessage;
import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.SubscriptionCategoryName;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DoremiSubscription {

    private LocalDate subscriptionStartDate;
    private final Map<SubscriptionCategoryName,SubscriptionPlan> categoryNameSubscriptionPlanMap;
    private TopupPlan topupPlan;

    public DoremiSubscription() {
        categoryNameSubscriptionPlanMap = new EnumMap<>(SubscriptionCategoryName.class);
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Map<SubscriptionCategoryName, SubscriptionPlan> getCategoryNameSubscriptionPlanMap() {
        return categoryNameSubscriptionPlanMap;
    }


    public void setTopupPlan(TopupPlan topupPlan) {
        this.topupPlan = topupPlan;
    }

    public boolean isTopupPlanActive(){
        return topupPlan != null;
    }

    public boolean isCategoryPlanActive(SubscriptionCategoryName categoryName){
        return categoryNameSubscriptionPlanMap.containsKey(categoryName);
    }

    public boolean isSubscriptionActive(){
        return categoryNameSubscriptionPlanMap.size() == 0;
    }

    public void printRenewalDetails(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StaticConstantValue.DATE_FORMAT);

        AtomicInteger renewalAmount = new AtomicInteger();

        categoryNameSubscriptionPlanMap.forEach((subscriptionCategoryName, subscriptionPlan) -> {

            System.out.println(ProgramMessage.RENEWAL_REMINDER+StaticConstantValue.SPACE_SEPARATOR
                    +subscriptionCategoryName+StaticConstantValue.SPACE_SEPARATOR+
                    formatter.format(subscriptionStartDate.plusMonths(subscriptionPlan.validity).minusDays(StaticConstantValue.SUBSCRIPTION_MINUS_DAYS)));

            renewalAmount.addAndGet(subscriptionPlan.price);

        });

        if (topupPlan != null)
            renewalAmount.addAndGet(topupPlan.price*topupPlan.validity);

        System.out.println(ProgramMessage.RENEWAL_AMOUNT+StaticConstantValue.SPACE_SEPARATOR+renewalAmount);
    }

    public boolean isSubscriptionStarted(){
        return subscriptionStartDate == null;
    }

}
