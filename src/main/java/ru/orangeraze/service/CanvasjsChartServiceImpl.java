package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.model.CanvasjsChartData;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CanvasjsChartServiceImpl implements CanvasjsChartService {

    private final CanvasjsChartData canvasjsChartData;

    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData(UserDetailsBO userDetailsBO, String name) {
        return canvasjsChartData.getCanvasjsDataList(userDetailsBO, name);
    }
}

