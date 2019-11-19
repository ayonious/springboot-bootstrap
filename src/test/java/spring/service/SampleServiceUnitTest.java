package spring.service;

import org.junit.Test;
import spring.dto.BodyDto;

import static org.junit.Assert.assertEquals;

public class SampleServiceUnitTest {

    @Test
    public void shouldTestHappyPath() {

        SampleService service = new SampleService();
        BodyDto b = new BodyDto(true, "asdf", 0L);
        assertEquals(service.findResult(10L, b),"updatedDatase with10BodyDto(isBody=true, id1=asdf, someStupidId=0)null");
    }
}