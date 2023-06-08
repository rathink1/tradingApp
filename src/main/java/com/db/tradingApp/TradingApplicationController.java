package com.db.tradingApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradingApplicationController {

    @GetMapping("/execute")
    public int executeTradingAlgorithm(@RequestParam int signal) {
        return signal;
    }

}
