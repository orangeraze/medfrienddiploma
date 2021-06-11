package ru.orangeraze.service;

import ru.orangeraze.bo.UserDetailsBO;

import java.util.List;
import java.util.Map;

public interface CanvasjsChartService {

    List<List<Map<Object, Object>>> getCanvasjsChartData(UserDetailsBO userDetailsBO, String name);

}
