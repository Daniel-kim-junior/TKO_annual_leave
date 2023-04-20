package tko.ManageSystem.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Spring boot integration Test
 * CalenderController("/calendar/${month})
 *
 * date : 2023-04-17
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalendarControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getCalendar() throws Exception {
        mvc.perform(get("/calendar?year=2023&month=5"))
                .andExpect(status().isOk());
    }
}