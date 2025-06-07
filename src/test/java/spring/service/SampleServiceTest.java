package spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.dto.BodyDto;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(properties = {
    "home.name=test-value"
})
class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    void shouldFindResult() {
        // given
        Long amount = 100L;
        BodyDto bodyDto = new BodyDto(true, "test-id", 123L);

        // when
        String result = sampleService.findResult(amount, bodyDto);

        // then
        assertThat(result).contains("100")
                         .contains("test-id")
                         .contains("123")
                         .contains("test-value");
    }
} 