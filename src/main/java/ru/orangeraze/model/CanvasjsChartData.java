package ru.orangeraze.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.service.AnalysisService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CanvasjsChartData {

    private final AnalysisService analysisService;


    public List<List<Map<Object, Object>>> getCanvasjsDataList(UserDetailsBO userDetailsBO, @RequestParam(value = "name") String name) {
        List<List<Map<Object, Object>>> list = new ArrayList<>();
        List<Map<Object, Object>> dataPoints1 = new ArrayList<>();
        List<AnalysisBO> analyzes = analysisService.getAllByName(userDetailsBO, name);
        analyzes.forEach(analysis -> {
            Map<Object, Object> map = new HashMap<>();
            map.put("x", analysis.getDate().getYear());
            map.put("y", analysis.getValue());
            dataPoints1.add(map);
        });
        list.add(dataPoints1);
        return list;
    }
}