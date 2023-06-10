package com.db.tradingApp.service.signalService;

import com.db.tradingApp.service.Algo;

public class SignalCommandFactory {
    public static SignalCommand createSignalCommand(int signal, Algo algo) {
        return switch (signal) {
            case 1 -> new SignalOneCommandImpl(algo);
            case 2 -> new SignalTwoCommandImpl(algo);
            case 3 -> new SignalThreeCommandImpl(algo);

//          add new signalCommand implementation here

            default -> new SignalDefaultCommandImpl(algo);
        };
    }
}
