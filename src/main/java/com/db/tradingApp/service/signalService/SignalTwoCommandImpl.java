package com.db.tradingApp.service.signalService;

import com.db.tradingApp.service.Algo;

public class SignalTwoCommandImpl implements SignalCommand {

    private final Algo algo;

    public SignalTwoCommandImpl(Algo algo) {
        this.algo = algo;
    }

    public void execute() {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }
}
