package pl.simpleascoding.tutoringplatform.service.user;

import org.springframework.stereotype.Service;
import pl.simpleascoding.tutoringplatform.dto.requests.ChangeUserPasswordDTO;
import pl.simpleascoding.tutoringplatform.dto.requests.CreateUserDTO;

@Service
interface UserService {

    void createUser(CreateUserDTO dto, String rootUrl);

    void confirmUserRegistration(String token);

    void changeUserPassword(ChangeUserPasswordDTO dto, String username);

}
