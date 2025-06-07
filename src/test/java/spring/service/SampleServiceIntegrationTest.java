package spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.dto.BodyDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleServiceIntegrationTest {

    @Autowired
    private SampleService service;

    @Test
    void shouldTestHappyPathOfIntegration() {
        // given
        BodyDto bodyDto = new BodyDto(true, "asdf", 0L);
        
        // when
        String result = service.findResult(10L, bodyDto);
        
        // then
        assertThat(result).isEqualTo("updatedDatase with10BodyDto(isBody=true, id1=asdf, someStupidId=0)somethinginTestMode");
    }
}