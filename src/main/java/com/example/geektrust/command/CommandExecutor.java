package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;

public abstract class CommandExecutor {

    protected DoremiSubscriptionService doremiSubScriptionService;

    protected CommandExecutor(final DoremiSubscriptionService doremiSubScriptionService){
        this.doremiSubScriptionService = doremiSubScriptionService;
    }

    protected abstract void validate(Command command);

    public abstract void execute(final Command command);

}
