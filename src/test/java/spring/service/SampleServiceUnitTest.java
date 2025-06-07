package spring.service;

import org.junit.jupiter.api.Test;
import spring.dto.BodyDto;

import static org.assertj.core.api.Assertions.assertThat;

class SampleServiceUnitTest {

    @Test
    void shouldTestHappyPath() {
        // given
        SampleService service = new SampleService();
        BodyDto bodyDto = new BodyDto(true, "asdf", 0L);
        
        // when
        String result = service.findResult(10L, bodyDto);
        
        // then
        assertThat(result).isEqualTo("updatedDatase with10BodyDto(isBody=true, id1=asdf, someStupidId=0)null");
    }
}