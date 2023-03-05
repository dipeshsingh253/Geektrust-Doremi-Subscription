package com.example.geektrust.command;

import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddSubscriptionCommandExecutorTest {

    private DoremiSubscriptionService doremiSubscriptionService;
    private AddSubscriptionCommandExecutor addSubscriptionCommandExecutor;

    @BeforeEach
    void setUp() {
        doremiSubscriptionService = mock(DoremiSubscriptionService.class);
        addSubscriptionCommandExecutor = new AddSubscriptionCommandExecutor(doremiSubscriptionService);
    }

    @Test
    void testValidateAddSubscriptionThrowsInvalidCommandException(){

        // passing one params
        assertThrows(
                InvalidCommandException.class,
                () -> {
                    addSubscriptionCommandExecutor.validate(new Command("ADD_SUBSCRIPTION MUSIC"));
                }
        );

        // passing no params
        assertThrows(
                InvalidCommandException.class,
                () -> {
                    addSubscriptionCommandExecutor.validate(new Command("ADD_SUBSCRIPTION"));
                }
        );

    }

    @Test
    void testExecuteAddSubscriptionCommand(){
        addSubscriptionCommandExecutor.execute(new Command("ADD_SUBSCRIPTION MUSIC FREE"));
        verify(doremiSubscriptionService).addSubscription(SubscriptionCategoryName.MUSIC, SubscriptionPlanName.FREE);
    }


}