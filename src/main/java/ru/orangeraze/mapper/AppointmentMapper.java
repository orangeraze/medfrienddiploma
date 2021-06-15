package ru.orangeraze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Appointment;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    ru.orangeraze.mapper.AppointmentMapper INSTANCE = Mappers.getMapper(ru.orangeraze.mapper.AppointmentMapper.class);

    List<AppointmentBO> toAppointmentBO(List<Appointment> appointments);

    Analysis fromAppointmentDTO(AppointmentDTO appointmentDTO);

}
