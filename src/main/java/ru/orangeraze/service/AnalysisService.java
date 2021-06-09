package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.repository.AnalysisRepository;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;

    public void saveAnalysis(Analysis analysis) {
        analysisRepository.save(analysis);
    }
}
