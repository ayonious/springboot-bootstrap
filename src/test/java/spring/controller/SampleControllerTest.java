package spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.dto.BodyDto;
import spring.service.SampleService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class TestConfig {
        @Bean
        SampleService sampleService() {
            return new SampleService() {
                @Override
                public String findResult(Long amount, BodyDto dto) {
                    return "test response";
                }
            };
        }
    }

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
                .andExpect(content().string("test response"));
    }
} 