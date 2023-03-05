package com.example.geektrust.command;

import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PrintRenewalDetailsCommandExecutorTest {


    private DoremiSubscriptionService doremiSubscriptionService;
    private PrintRenewalDetailsCommandExecutor printRenewalDetailsCommandExecutor;
    @BeforeEach
    void setUp() {

        doremiSubscriptionService = mock(DoremiSubscriptionService.class);
        printRenewalDetailsCommandExecutor = new PrintRenewalDetailsCommandExecutor(doremiSubscriptionService);

    }

    @Test
    void executePrintRenewalDetailsCommand(){
        printRenewalDetailsCommandExecutor.execute(new Command("PRINT_RENEWAL_DETAILS"));
        verify(doremiSubscriptionService).printRenewalDetails();
    }


}