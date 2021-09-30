package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.AnalysisDTO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Appointment;
import ru.orangeraze.entity.User;
import ru.orangeraze.mapper.AnalysisMapper;
import ru.orangeraze.mapper.AppointmentMapper;
import ru.orangeraze.repository.AnalysisRepository;
import ru.orangeraze.repository.AppointmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserService userService;

    public List<AppointmentBO> save(AppointmentDTO appointmentDTO, UserDetailsBO userDetailsBO) {
        Appointment appointment = AppointmentMapper.INSTANCE.fromAppointmentDTO(appointmentDTO);
        appointment.setUser(userService.getById(userDetailsBO.getId()));
        appointmentRepository.save(appointment);
        return getAll(userDetailsBO);
    }

    public List<AppointmentBO> getAll(UserDetailsBO userDetailsBO) {
        User user = userService.getById(userDetailsBO.getId());
        return AppointmentMapper.INSTANCE.toAppointmentBO(appointmentRepository.findAllByUser(user));
    }
}
