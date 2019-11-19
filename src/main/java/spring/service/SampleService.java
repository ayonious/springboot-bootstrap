package spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.dto.BodyDto;

@Service
@Component
public class SampleService {

    @Value("${home.name}")
    String testValue;

    public String findResult(Long amount, BodyDto dto) {
        return "updatedDatase with" + amount.toString() + dto.toString() + testValue;
    }
}
