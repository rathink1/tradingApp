package com.db.tradingApp;

import com.db.tradingApp.service.Algo;
import com.db.tradingApp.service.Application;
import com.db.tradingApp.service.signalService.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ApplicationTest {

    @Mock
    private SignalCommand signalCommand;

    @Spy
    private Application application = new Application();

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testHandleSignalCallsSignalCommand() {
        int signal = 4;
        doReturn(signalCommand).when(application).getSignalCommand(eq(4), any(Algo.class));
        application.handleSignal(signal);

        verify(signalCommand).execute();
    }

    @Test
    public void testGetSignalCommand() {
        int signal = 1;
        SignalCommand factoryGeneratedClass = application.getSignalCommand(signal, new Algo());
        assertTrue(factoryGeneratedClass instanceof SignalOneCommandImpl);

        signal = 2;
        factoryGeneratedClass = application.getSignalCommand(signal, new Algo());
        assertTrue(factoryGeneratedClass instanceof SignalTwoCommandImpl);

        signal = 3;
        factoryGeneratedClass = application.getSignalCommand(signal, new Algo());
        assertTrue(factoryGeneratedClass instanceof SignalThreeCommandImpl);

        signal = 4;
        factoryGeneratedClass = application.getSignalCommand(signal, new Algo());
        assertTrue(factoryGeneratedClass instanceof SignalDefaultCommandImpl);
    }

    @Test
    public void testHandleSignalOne() {
        int signal = 1;
        application.handleSignal(signal);
        assertEquals("setUp\n" +
                "setAlgoParam 1,60\n" +
                "performCalc\n" +
                "submitToMarket\n" +
                "doAlgo\n", outContent.toString());
    }

    @Test
    public void testHandleSignalTwo() {
        int signal = 2;
        application.handleSignal(signal);
        assertEquals("reverse\n" +
                "setAlgoParam 1,80\n" +
                "submitToMarket\n" +
                "doAlgo\n", outContent.toString());
    }

    @Test
    public void testHandleSignalThree() {
        int signal = 3;
        application.handleSignal(signal);
        assertEquals("setAlgoParam 1,90\n" +
                "setAlgoParam 2,15\n" +
                "performCalc\n" +
                "submitToMarket\n" +
                "doAlgo\n", outContent.toString());
    }

    @Test
    public void testHandleSignalDefault() {
        int signal = 4;
        application.handleSignal(signal);
        assertEquals("cancelTrades\n" + "doAlgo\n", outContent.toString());
    }
}
