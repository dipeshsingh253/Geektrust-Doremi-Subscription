package com.example.geektrust.command;

import com.example.geektrust.enums.CommandName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;

public class PrintRenewalDetailsCommandExecutor extends CommandExecutor{

    public static final CommandName COMMAND_NAME = CommandName.PRINT_RENEWAL_DETAILS;

    protected PrintRenewalDetailsCommandExecutor(DoremiSubscriptionService doremiSubScriptionService) {
        super(doremiSubScriptionService);
    }

    @Override
    public void validate(Command command) {
        if (command.getParams().size() != COMMAND_NAME.getMinimumRequiredParams())
            throw new InvalidCommandException();
    }

    @Override
    public void execute(Command command) {
        validate(command);

        try {
            doremiSubScriptionService.printRenewalDetails();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
