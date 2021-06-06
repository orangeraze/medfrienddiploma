package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.UserBO;
import ru.orangeraze.dto.UserDTO;
import ru.orangeraze.entity.User;
import ru.orangeraze.mapper.UserMapper;
import ru.orangeraze.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserBO register (UserDTO userDTO) {
        User newUser = UserMapper.INSTANCE.fromUserDTO(userDTO);

        return UserMapper.INSTANCE.toUserBO(userRepository.save(newUser));
    }
}
