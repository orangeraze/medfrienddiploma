package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.UserBO;
import ru.orangeraze.dto.UserDTO;
import ru.orangeraze.entity.User;
import ru.orangeraze.mapper.UserMapper;
import ru.orangeraze.repository.UserRepository;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public UserBO register (UserDTO userDTO) {
        User newUser = UserMapper.INSTANCE.fromUserDTO(userDTO);

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));


        return UserMapper.INSTANCE.toUserBO(userRepository.save(newUser));
    }

    public User getById(UUID id) {
        return userRepository.findById(id).get();
    }
}
