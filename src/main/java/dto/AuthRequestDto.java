package dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuthRequestDto {
    String email;
    String password;
}
