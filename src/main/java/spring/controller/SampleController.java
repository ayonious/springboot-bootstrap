package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.BodyDto;
import spring.service.SampleService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/v1/ayon/controller")
public class SampleController {

    @Autowired
    SampleService service;

    @RequestMapping(value = "/multiply/{amount}/update", method = POST)
    public String delAmount(@PathVariable Long amount,
                            @RequestBody BodyDto dto) {
        return service.findResult(amount, dto);
    }
}
