package pl.simpleascoding.tutoringplatform.service.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.simpleascoding.tutoringplatform.dto.RscpDTO;
import pl.simpleascoding.tutoringplatform.dto.SignAsTeacherDTO;
import pl.simpleascoding.tutoringplatform.dto.UserDTO;

public interface TeacherService {
    RscpDTO<?> addTeacherRoleToUser(SignAsTeacherDTO requestDTO);

    RscpDTO<Page<UserDTO>> findAllTeachers(Pageable pageable);
}
