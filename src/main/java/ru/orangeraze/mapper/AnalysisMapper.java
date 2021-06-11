package ru.orangeraze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.dto.AnalysisDTO;
import ru.orangeraze.entity.Analysis;

import java.util.List;

@Mapper
public interface AnalysisMapper {

    AnalysisMapper INSTANCE = Mappers.getMapper(AnalysisMapper.class);

    List<AnalysisBO> toAnalysisBO(List<Analysis> analysis);

    Analysis fromAnalysisDTO(AnalysisDTO analysisDTO);
}
