package pl.simpleascoding.tutoringplatform.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.simpleascoding.tutoringplatform.dto.requests.ChangeUserPasswordDTO;
import pl.simpleascoding.tutoringplatform.dto.requests.CreateUserDTO;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public void createUser(CreateUserDTO dto, String rootUrl) {

        userService.createUser(dto, rootUrl);

    }

    public void confirmUserRegistration(String tokenValue) {

        userService.confirmUserRegistration(tokenValue);

    }

    public void changeUserPassword(ChangeUserPasswordDTO dto, String username) {

        userService.changeUserPassword(dto, username);

    }

}
