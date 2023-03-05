package com.example.geektrust.constant;

public class StaticConstantValue {

    private StaticConstantValue() {
    }

    // separators used in project
    public static final String SPACE_SEPARATOR = " ";

    // string date format

    public static final String DATE_FORMAT = "dd-MM-yyyy";


    // Index of command parameters. Parameters follow zero based indexing because we have used List to store parameters.

    public static final int COMMAND_PARAM_ONE = 0;
    public static final int COMMAND_PARAM_TWO = 1;

    // default value for subscription plans

    public static final int FREE_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PERSONAL_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PREMIUM_MUSIC_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 3;
    public static final int FREE_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PERSONAL_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PREMIUM_VIDEO_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 3;
    public static final int FREE_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PERSONAL_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 1;
    public static final int PREMIUM_PODCAST_SUBSCRIPTION_PLAN_DEFAULT_VALIDITY_MONTHS = 3;
    public static final int FREE_MUSIC_SUBSCRIPTION_PLAN_PRICE = 0;
    public static final int PERSONAL_MUSIC_SUBSCRIPTION_PLAN_PRICE = 100;
    public static final int PREMIUM_MUSIC_SUBSCRIPTION_PLAN_PRICE = 250;
    public static final int FREE_VIDEO_SUBSCRIPTION_PLAN_PRICE = 0;
    public static final int PERSONAL_VIDEO_SUBSCRIPTION_PLAN_PRICE = 200;
    public static final int PREMIUM_VIDEO_SUBSCRIPTION_PLAN_PRICE = 500;
    public static final int FREE_PODCAST_SUBSCRIPTION_PLAN_PRICE = 0;
    public static final int PERSONAL_PODCAST_SUBSCRIPTION_PLAN_PRICE = 100;
    public static final int PREMIUM_PODCAST_SUBSCRIPTION_PLAN_PRICE = 300;


    // default topup plan values

    public static final int FOUR_DEVICE_TOPUP_PLAN_PRICE_PER_MONTH = 50;
    public static final int TEN_DEVICE_TOPUP_PLAN_PRICE_PER_MONTH = 100;


    // number of days for reminder to be sent before the subscription ends
    public static final int SUBSCRIPTION_MINUS_DAYS = 10;
}
