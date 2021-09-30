package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.bo.ChronologyBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.dto.ChronologyDTO;
import ru.orangeraze.entity.Appointment;
import ru.orangeraze.entity.Chronology;
import ru.orangeraze.entity.User;
import ru.orangeraze.mapper.AppointmentMapper;
import ru.orangeraze.mapper.ChronologyMapper;
import ru.orangeraze.repository.AppointmentRepository;
import ru.orangeraze.repository.ChronologyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChronologyService {

    private final ChronologyRepository chronologyRepository;
    private final UserService userService;

    public List<ChronologyBO> save(ChronologyDTO chronologyDTO, UserDetailsBO userDetailsBO) {
        Chronology chronology = ChronologyMapper.INSTANCE.fromChronologyDTO(chronologyDTO);
        chronology.setUser(userService.getById(userDetailsBO.getId()));
        chronologyRepository.save(chronology);
        return getAll(userDetailsBO);
    }

    public List<ChronologyBO> getAll(UserDetailsBO userDetailsBO) {
        User user = userService.getById(userDetailsBO.getId());
        return ChronologyMapper.INSTANCE.toChronologyBO(chronologyRepository.findAllByUser(user));
    }

    public List<ChronologyBO> getAllById(UserDetailsBO userDetailsBO, ChronologyBO chronologyBO) {
        User user = userService.getById(userDetailsBO.getId());
        return ChronologyMapper.INSTANCE.toChronologyBO(chronologyRepository.findAllByUser(user));
    }
}