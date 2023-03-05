package com.example.geektrust.command;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.CommandName;
import com.example.geektrust.enums.TopupName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;

public class AddTopupCommandExecutor extends CommandExecutor{

    public static final CommandName COMMAND_NAME = CommandName.ADD_TOPUP;

    protected AddTopupCommandExecutor(DoremiSubscriptionService doremiSubScriptionService) {
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

        try{
            doremiSubScriptionService.addTopup(TopupName.valueOf(command.getParams().get(StaticConstantValue.COMMAND_PARAM_ONE)),
                    Integer.parseInt(command.getParams().get(StaticConstantValue.COMMAND_PARAM_TWO)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
