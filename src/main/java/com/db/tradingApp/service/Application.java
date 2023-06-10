package com.db.tradingApp.service;

import com.db.tradingApp.service.signalService.SignalCommand;
import com.db.tradingApp.service.signalService.SignalCommandFactory;
import org.springframework.stereotype.Component;

/**
 * This is your team’s code and should be changed as you see fit.
 */
@Component
public class Application {

    public void handleSignal(int signal) {
        Algo algo = new Algo();
        SignalCommand command = getSignalCommand(signal, algo);
        command.execute();
        algo.doAlgo();
    }

    public SignalCommand getSignalCommand(int signal, Algo algo) {
        return SignalCommandFactory.createSignalCommand(signal, algo);
    }

}
