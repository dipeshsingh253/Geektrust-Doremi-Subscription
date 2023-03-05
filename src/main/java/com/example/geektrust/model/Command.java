package com.example.geektrust.model;

import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.enums.CommandName;
import com.example.geektrust.exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private final CommandName commandName;
    private final List<String> params;

    public Command(final String inputLine) {

        final List<String> inputs = Arrays.stream(inputLine.trim().split(StaticConstantValue.SPACE_SEPARATOR))
                .map(String :: trim)
                .filter(input -> input.length() > 0)
                .collect(Collectors.toList());

        if (inputs.isEmpty()) throw new InvalidCommandException();

        commandName = CommandName.valueOf(inputs.get(0));
        inputs.remove(0);
        params = inputs;

    }

    public CommandName getCommandName(){
        return commandName;
    }

    public List<String> getParams(){
        return params;
    }


}
