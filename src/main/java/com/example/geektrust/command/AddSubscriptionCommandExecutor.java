package com.example.geektrust.command;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.CommandName;
import com.example.geektrust.enums.SubscriptionCategoryName;
import com.example.geektrust.enums.SubscriptionPlanName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;

public class AddSubscriptionCommandExecutor extends CommandExecutor{

    public static final CommandName COMMAND_NAME = CommandName.ADD_SUBSCRIPTION;



    protected AddSubscriptionCommandExecutor(DoremiSubscriptionService doremiSubScriptionService) {
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
            doremiSubScriptionService.addSubscription(SubscriptionCategoryName.valueOf(command.getParams().get(StaticConstantValue.COMMAND_PARAM_ONE)),
                    SubscriptionPlanName.valueOf(command.getParams().get(StaticConstantValue.COMMAND_PARAM_TWO)));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
