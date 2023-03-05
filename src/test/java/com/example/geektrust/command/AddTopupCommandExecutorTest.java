package com.example.geektrust.command;

import com.example.geektrust.enums.TopupName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddTopupCommandExecutorTest {

    private DoremiSubscriptionService doremiSubscriptionService;
    private AddTopupCommandExecutor addTopupCommandExecutor;

    @BeforeEach
    void setUp() {
        doremiSubscriptionService = mock(DoremiSubscriptionService.class);
        addTopupCommandExecutor = new AddTopupCommandExecutor(doremiSubscriptionService);
    }

    @Test
    void testValidateAddTopupCommandThrowsInvalidCommandException(){
        // passing one param
        assertThrows(
                InvalidCommandException.class,
                () -> {
                    addTopupCommandExecutor.validate(new Command("ADD_TOPUP FOUR_DEVICE"));
                }
        );

        // passing no params
        assertThrows(
                InvalidCommandException.class,
                () -> {
                    addTopupCommandExecutor.validate(new Command("ADD_TOPUP"));
                }
        );
    }

    @Test
    void testExecuteAddTopupCommand(){
        addTopupCommandExecutor.execute(new Command("ADD_TOPUP FOUR_DEVICE 3"));
        verify(doremiSubscriptionService).addTopup(TopupName.FOUR_DEVICE,3);
    }

}