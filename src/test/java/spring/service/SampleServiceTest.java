package spring.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.dto.BodyDto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class SampleServiceTest {

    @Autowired
    SampleService service;

    @Test
    public void shouldTestHappyPath() {

        BodyDto b = new BodyDto(true, "asdf", 0L);
        assertThat(service.findResult(10L, b),is("asdf"));
    }
}