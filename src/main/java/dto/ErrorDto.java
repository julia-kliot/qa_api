package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString


public class ErrorDto {
    Integer code;
    String details;
    String message;
}
