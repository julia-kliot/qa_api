package dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AuthResponseDto {
    Boolean registration;
    String status;
    String token;
}
