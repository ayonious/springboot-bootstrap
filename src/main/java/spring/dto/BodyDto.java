package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class BodyDto {
    Boolean isBody;
    String id1;
    Long someStupidId;
}