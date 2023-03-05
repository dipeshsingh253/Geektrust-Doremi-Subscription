package com.example.geektrust.command;

import com.example.geektrust.enums.CommandName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;
import com.example.geektrust.utility.DateUtility;


public class StartSubscriptionCommandExecutor extends CommandExecutor{

    public static final CommandName COMMAND_NAME = CommandName.START_SUBSCRIPTION;

    protected StartSubscriptionCommandExecutor(DoremiSubscriptionService doremiSubScriptionService) {
        super(doremiSubScriptionService);
    }

    @Override
    public void validate(Command command) {

        if (command.getParams().size() != COMMAND_NAME.getMinimumRequiredParams())
            throw new InvalidCommandException();

        DateUtility.isValidDate(DateUtility.convertStringToDate(command.getParams().get(0)));

    }

    @Override
    public void execute(Command command) {

        try {
            validate(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        doremiSubScriptionService.startSubscription(DateUtility.convertStringToDate(command.getParams().get(0)));

    }

}
