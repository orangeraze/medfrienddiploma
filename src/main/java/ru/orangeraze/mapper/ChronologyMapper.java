package ru.orangeraze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.bo.ChronologyBO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.dto.ChronologyDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Appointment;
import ru.orangeraze.entity.Chronology;

import java.util.List;

@Mapper
public interface ChronologyMapper {

    ChronologyMapper INSTANCE = Mappers.getMapper(ru.orangeraze.mapper.ChronologyMapper.class);

    List<ChronologyBO> toChronologyBO(List<Chronology> chronologies);

    Chronology fromChronologyDTO(ChronologyDTO chronologyDTO);

}
