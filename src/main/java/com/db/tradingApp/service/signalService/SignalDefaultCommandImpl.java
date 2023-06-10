package com.db.tradingApp.service.signalService;

import com.db.tradingApp.service.Algo;

public class SignalDefaultCommandImpl implements SignalCommand {

    private final Algo algo;

    public SignalDefaultCommandImpl(Algo algo) {
        this.algo = algo;
    }

    public void execute() {
        algo.cancelTrades();
    }
}
