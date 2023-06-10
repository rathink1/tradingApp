package com.db.tradingApp.service.signalService;

import com.db.tradingApp.service.Algo;

public class SignalOneCommandImpl implements SignalCommand {

    private final Algo algo;

    public SignalOneCommandImpl(Algo algo) {
        this.algo = algo;
    }

    public void execute() {
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
