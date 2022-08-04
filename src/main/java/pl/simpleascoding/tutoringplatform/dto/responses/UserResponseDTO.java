package pl.simpleascoding.tutoringplatform.dto.responses;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Immutable
@NoArgsConstructor
public class UserResponseDTO {
    private String username;
    private String name;
    private String surname;
    private String email;
    private boolean enabled;
    private boolean locked;
}
