package ru.orangeraze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.UserBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.UserDTO;
import ru.orangeraze.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserBO toUserBO(User user);

    User fromUserDTO(UserDTO userDTO);

    @Mapping(target = "username", source = "email")
    UserDetailsBO toUserDetailsBO(User user);

}