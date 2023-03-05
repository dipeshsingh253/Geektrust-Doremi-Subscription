package com.example.geektrust.enums;

public enum CommandName {
    START_SUBSCRIPTION(1),
    ADD_SUBSCRIPTION(2),
    ADD_TOPUP(2),
    PRINT_RENEWAL_DETAILS(0);

    private final int minimumRequiredParams;

    CommandName(int minimumRequiredParams) {
        this.minimumRequiredParams = minimumRequiredParams;
    }

    public int getMinimumRequiredParams() {
        return minimumRequiredParams;
    }
}
