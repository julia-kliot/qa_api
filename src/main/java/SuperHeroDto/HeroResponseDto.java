package SuperHeroDto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HeroResponseDto {
    String birthDate;
    String city;
    String fullName;
    String gender;
    int id;
    String mainSkill;
    String phone;

}
