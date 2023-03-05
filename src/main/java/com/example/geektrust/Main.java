package com.example.geektrust;

import com.example.geektrust.command.CommandExecutorFactory;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.DoremiSubscription;
import com.example.geektrust.service.DoremiSubscriptionService;
import com.example.geektrust.service.DoremiSubscriptionServiceImpl;
import com.example.geektrust.service.RenewalService;
import com.example.geektrust.service.RenewalServiceImpl;

import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

            if (args.length == 0) throw new FileNotFoundException();

    		final String fileName = args[0];
    		
    		readInputFile(fileName);
    	
    }

    private static void readInputFile(final String fileName) {
        final DoremiSubscription doremiSubscription = new DoremiSubscription();
        final RenewalService renewalService = new RenewalServiceImpl(doremiSubscription);
        final DoremiSubscriptionService doremiSubscriptionService = new DoremiSubscriptionServiceImpl(doremiSubscription, renewalService);
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(doremiSubscriptionService);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
              executeCommand(commandExecutorFactory,inputLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeCommand(CommandExecutorFactory commandExecutorFactory,String inputLine){



        try {
            commandExecutorFactory.getCommandExecutor(new Command(inputLine)).execute(new Command(inputLine));
        } catch (RuntimeException e) {
            // handle the runtime exception here
            System.out.println(e.getMessage());
        }
    }


}
