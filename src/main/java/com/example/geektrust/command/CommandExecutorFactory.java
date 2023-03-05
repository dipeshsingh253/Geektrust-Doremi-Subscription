package com.example.geektrust.command;

import com.example.geektrust.enums.CommandName;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.DoremiSubscriptionService;

import java.util.EnumMap;
import java.util.Map;

public class CommandExecutorFactory {

    private final Map<CommandName,CommandExecutor> commands = new EnumMap<>(CommandName.class);

    public CommandExecutorFactory(final DoremiSubscriptionService doremiSubScriptionService){

        commands.put(StartSubscriptionCommandExecutor.COMMAND_NAME,new StartSubscriptionCommandExecutor(doremiSubScriptionService));
        commands.put(AddSubscriptionCommandExecutor.COMMAND_NAME,new AddSubscriptionCommandExecutor(doremiSubScriptionService));
        commands.put(AddTopupCommandExecutor.COMMAND_NAME,new AddTopupCommandExecutor(doremiSubScriptionService));
        commands.put(PrintRenewalDetailsCommandExecutor.COMMAND_NAME,new PrintRenewalDetailsCommandExecutor(doremiSubScriptionService));


    }

    public CommandExecutor getCommandExecutor(final Command command){

        if (!commands.containsKey(command.getCommandName())) throw new InvalidCommandException("invalid command");

        return commands.get(command.getCommandName());
    }

}
