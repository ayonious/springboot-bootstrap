package spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.BodyDto;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Service
public class SampleService {

    public String findResult(Long amount, BodyDto dto) {
        return "updatedDatase with" + amount.toString() + dto.toString();
    }
}
