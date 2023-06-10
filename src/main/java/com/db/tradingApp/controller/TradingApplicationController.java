package com.db.tradingApp.controller;

import com.db.tradingApp.service.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradingApplicationController {

    @Autowired
    private Application application;

    @GetMapping("/execute")
    public void executeTradingAlgorithm(@RequestParam int signal) {
        application.handleSignal(signal);
    }

}
