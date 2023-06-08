package com.db.tradingApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class TradingApplicationControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private TradingApplicationController tradingApplicationController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tradingApplicationController).build();
    }

    @Test
    public void testExecuteTradingAlgorithm() throws Exception {
        int testSignal = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/trade/execute")
                        .param("signal", String.valueOf(testSignal))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content()
                                .string(String.valueOf(testSignal)));
    }
}
