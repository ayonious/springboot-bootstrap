package spring.controller;

import tools.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.dto.BodyDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonMapper objectMapper;

    @Test
    void shouldMultiplyAndUpdate() throws Exception {
        // given
        Long amount = 100L;
        BodyDto bodyDto = new BodyDto(true, "test-id", 123L);

        // when & then
        mockMvc.perform(post("/v1/ayon/controller/multiply/{amount}/update", amount)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bodyDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("updatedDatase with100BodyDto(isBody=true, id1=test-id, someStupidId=123)somethinginTestMode"));
    }
    @Test
    void shouldAcceptOriginalReadmePayload() throws Exception {
        mockMvc.perform(post("/v1/ayon/controller/multiply/12/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"isBody":"false","id1":"xyz","someStupidId":"123321"}
                        """))
                .andExpect(status().isOk())
                .andExpect(content().string("updatedDatase with12BodyDto(isBody=false, id1=xyz, someStupidId=123321)somethinginTestMode"));
    }

    @Test
    void shouldRejectMalformedJson() throws Exception {
        mockMvc.perform(post("/v1/ayon/controller/multiply/12/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{broken"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldRejectNonNumericAmount() throws Exception {
        mockMvc.perform(post("/v1/ayon/controller/multiply/invalid/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"isBody":false,"id1":"xyz","someStupidId":123321}
                        """))
                .andExpect(status().isBadRequest());
    }
} 