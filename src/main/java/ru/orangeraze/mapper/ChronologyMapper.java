package ru.orangeraze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.dto.ChronologyDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Appointment;
import ru.orangeraze.entity.Chronology;

import java.util.List;

@Mapper
public interface ChronologyMapper {

    ru.orangeraze.mapper.ChronologyMapper INSTANCE = Mappers.getMapper(ru.orangeraze.mapper.ChronologyMapper.class);

    List<AppointmentBO> toChronologyBO(List<Chronology> chronologies);

    Analysis fromChronologyDTO(ChronologyDTO chronologyDTO);

}
