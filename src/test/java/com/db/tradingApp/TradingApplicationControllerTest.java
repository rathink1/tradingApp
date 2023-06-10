package com.db.tradingApp;

import com.db.tradingApp.controller.TradingApplicationController;
import com.db.tradingApp.service.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class TradingApplicationControllerTest {

    private MockMvc mockMvc;
    @Mock
    private Application application;
    @InjectMocks
    private TradingApplicationController tradingApplicationController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tradingApplicationController).build();
    }

    @Test
    public void testTradingApplicationControllerInvocation() throws Exception {
        int testSignal = 4;

        mockMvc.perform(MockMvcRequestBuilders.get("/trade/execute")
                        .param("signal", String.valueOf(testSignal))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testExecuteTradingAlgorithm() throws Exception {
        int testSignal = 4;
        tradingApplicationController.executeTradingAlgorithm(testSignal);
        verify(application).handleSignal(testSignal);
    }


}
