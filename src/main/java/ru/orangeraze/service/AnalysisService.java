package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.AnalysisDTO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.User;
import ru.orangeraze.mapper.AnalysisMapper;
import ru.orangeraze.repository.AnalysisRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;
    private final UserService userService;

    public List<AnalysisBO> save(AnalysisDTO analysisDTO, UserDetailsBO userDetailsBO) {
        Analysis analysis = AnalysisMapper.INSTANCE.fromAnalysisDTO(analysisDTO);
        analysis.setUser(userService.getById(userDetailsBO.getId()));
        analysisRepository.save(analysis);
        return getAll(userDetailsBO);
    }

    public List<AnalysisBO> getAll(UserDetailsBO userDetailsBO) {
        User user = userService.getById(userDetailsBO.getId());
        return AnalysisMapper.INSTANCE.toAnalysisBO(analysisRepository.findAllByUser(user));
    }

    public List<AnalysisBO> getAllByName(UserDetailsBO userDetailsBO, String name) {
        User user = userService.getById(userDetailsBO.getId());
        return AnalysisMapper.INSTANCE.toAnalysisBO(analysisRepository.findAllByNameAndUser(name, user));
    }
}
