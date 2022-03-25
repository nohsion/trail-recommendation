package capstone_design.mini.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RoadController.class)
public class RoadControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void RoadDto가_리턴된다() throws Exception {
        String road_name = "길이름";
        String road_desc = "이 길은 아름답습니다.";
        double distance = 3.2;
        String time = "1시간30분";

        mvc.perform(
                        get("/road/dto")
                                .param("road_name", road_name)
                                .param("road_desc", road_desc)
                                .param("distance", String.valueOf(distance))
                                .param("time", time))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.road_name", is(road_name)))
                .andExpect(jsonPath("$.road_desc", is(road_desc)))
                .andExpect(jsonPath("$.distance", is(distance)))
                .andExpect(jsonPath("$.time", is(time)));

    }
}
