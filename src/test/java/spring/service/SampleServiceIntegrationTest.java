package spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.dto.BodyDto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
// this will run the whole spring context thats why we will be able to get access to Beans and Autowires
@SpringBootTest
public class SampleServiceIntegrationTest {

    @Autowired
    SampleService service;

    @Test
    public void shouldTestHappyPathOfIntegration() {

        BodyDto b = new BodyDto(true, "asdf", 0L);
        assertThat(service.findResult(10L, b),is("updatedDatase with10BodyDto(isBody=true, id1=asdf, someStupidId=0)somethinginTestMode"));
    }
}