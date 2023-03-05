package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommandExecutorFactoryTest {

    private CommandExecutorFactory commandExecutorFactory;
    @BeforeEach
    void setUp() {
        commandExecutorFactory = new CommandExecutorFactory(mock(DoremiSubscriptionService.class));
    }

    @Test
    void testFetchingCommandExecutor(){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(new Command("ADD_TOPUP FOUR_DEVICE"));
        assertNotNull(commandExecutor);
        assertTrue(commandExecutor instanceof AddTopupCommandExecutor);
    }

}