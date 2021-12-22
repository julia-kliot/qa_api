package SuperHeroDto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HeroRequiestDto {
    String birthDate;
    String city;
    String fullName;
    String gender;
    String mainSkill;
    String phone;
}
