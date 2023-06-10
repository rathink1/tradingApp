package com.db.tradingApp.service.signalService;

import com.db.tradingApp.service.Algo;

public class SignalThreeCommandImpl implements SignalCommand {

    private final Algo algo;

    public SignalThreeCommandImpl(Algo algo) {
        this.algo = algo;
    }

    public void execute() {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
