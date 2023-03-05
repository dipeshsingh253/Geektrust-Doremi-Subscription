package com.example.geektrust.command;

import com.example.geektrust.constant.ExceptionMessage;
import com.example.geektrust.enums.CommandName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.exception.InvalidDateException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import com.example.geektrust.utility.DateUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class StartSubscriptionCommandExecutorTest {

    private DoremiSubscriptionService doremiSubscriptionService;
    private StartSubscriptionCommandExecutor startSubscriptionCommandExecutor;
    @BeforeEach
    void setUp() {
        doremiSubscriptionService = mock(DoremiSubscriptionService.class);
        startSubscriptionCommandExecutor = new StartSubscriptionCommandExecutor(doremiSubscriptionService);
    }


    @Test
    void testValidateStartSubscriptionThrowsInvalidCommandException(){
        assertThrows(
                InvalidCommandException.class,
                () -> startSubscriptionCommandExecutor.validate(new Command("START_SUBSCRIPTION"))
        );
    }

    @Test
    void testValidateStartSubscriptionValidDateFormat(){

        InvalidDateException dateException = assertThrows(
                InvalidDateException.class,
                () -> startSubscriptionCommandExecutor.validate(new Command("START_SUBSCRIPTION 2022-02-20"))
        );

        assertEquals(ExceptionMessage.INVALID_DATE,dateException.getMessage());
    }

    @Test
    void testValidateStartSubscriptionCommandValidDate(){

        InvalidDateException dateException = assertThrows(
                InvalidDateException.class,
                () -> startSubscriptionCommandExecutor.validate(new Command("START_SUBSCRIPTION 31-13-2020"))
        );

        assertEquals(ExceptionMessage.INVALID_DATE,dateException.getMessage());
    }


    @Test
    void testExecuteStartSubscriptionCommand(){
        startSubscriptionCommandExecutor.execute(new Command("START_SUBSCRIPTION 20-02-2020"));
        verify(doremiSubscriptionService).startSubscription(DateUtility.convertStringToDate("20-02-2020"));
    }

}