package pl.simpleascoding.tutoringplatform.service.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.simpleascoding.tutoringplatform.domain.user.RoleType;
import pl.simpleascoding.tutoringplatform.domain.user.User;
import pl.simpleascoding.tutoringplatform.dto.RscpDTO;
import pl.simpleascoding.tutoringplatform.dto.SignAsTeacherDTO;
import pl.simpleascoding.tutoringplatform.dto.UserDTO;
import pl.simpleascoding.tutoringplatform.exception.UserIsAlreadyATeacherException;
import pl.simpleascoding.tutoringplatform.repository.UserRepository;
import pl.simpleascoding.tutoringplatform.rscp.RscpStatus;
import pl.simpleascoding.tutoringplatform.service.user.UserModelMapper;
import pl.simpleascoding.tutoringplatform.service.user.UserService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserModelMapper userModelMapper;

    @Override
    @Transactional
    public RscpDTO<?> addTeacherRoleToUser(SignAsTeacherDTO requestDTO) {
        User user = userService.getUserByUsername(requestDTO.username());
        if (!isUserAlreadyTeacher(user)) {
            addRoleToEntity(user, RoleType.TEACHER);
            return new RscpDTO<>(RscpStatus.OK, "Teacher role added to user.", null);
        } else {
            throw new UserIsAlreadyATeacherException();
        }
    }

    @Override
    public RscpDTO<Page<UserDTO>> findAllTeachers(Pageable pageable) {
        return createTeacherDtoPage(pageable);
    }

    private boolean isUserAlreadyTeacher(User user) {
        return user.getRoles().contains(RoleType.TEACHER);
    }

    private void addRoleToEntity(User user, RoleType roleType) {
        user.getRoles().add(roleType);
    }

    private RscpDTO<Page<UserDTO>> createTeacherDtoPage(Pageable pageable) {
        Page<UserDTO> userPage = userRepository.findUsersByRolesContaining(RoleType.TEACHER, pageable)
                .map(userModelMapper::mapUserEntityToUserDTO);

        return new RscpDTO<>(RscpStatus.OK, "Page returned.", userPage);
    }
}
