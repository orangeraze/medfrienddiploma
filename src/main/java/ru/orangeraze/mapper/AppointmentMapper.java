package ru.orangeraze.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper
public abstract class AppointmentMapper {

    public static AppointmentMapper INSTANCE = Mappers.getMapper(ru.orangeraze.mapper.AppointmentMapper.class);

    public abstract List<AppointmentBO> toAppointmentBO(List<Appointment> appointments);

    @Mapping(source = "time", target = "time", dateFormat = "yyyy-MM-dd HH:mm")
    public abstract AppointmentBO toAppointmentBO(Appointment appointment);

    public abstract Appointment fromAppointmentDTO(AppointmentDTO appointmentDTO);

//    @AfterMapping
//    public void convertDate(Appointment appointment, @MappingTarget AppointmentBO appointmentBO) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        appointmentBO.setTime(LocalDateTime.parse(dateTimeFormatter.format(appointmentBO.getTime()), dateTimeFormatter));
//    }
}
