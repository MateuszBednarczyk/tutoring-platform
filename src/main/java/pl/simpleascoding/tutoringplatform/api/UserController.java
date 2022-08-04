package pl.simpleascoding.tutoringplatform.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.simpleascoding.tutoringplatform.dto.requests.ChangeUserPasswordDTO;
import pl.simpleascoding.tutoringplatform.dto.requests.CreateUserDTO;
import pl.simpleascoding.tutoringplatform.service.user.UserFacade;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserFacade userFacade;

    @PostMapping
    ResponseEntity<String> createUser(@RequestBody CreateUserDTO dto, HttpServletRequest request) {
        userFacade.createUser(dto, request.getRequestURL().toString());

        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
    }

    @GetMapping("/confirm-registration")
    ResponseEntity<String> confirmRegistration(@RequestParam String tokenValue) {
        userFacade.confirmUserRegistration(tokenValue);

        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    ResponseEntity<String> changeUserPassword(@RequestBody ChangeUserPasswordDTO dto, Principal principal) {
        userFacade.changeUserPassword(dto, principal.getName());

        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
    }

}
