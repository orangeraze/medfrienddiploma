package ru.orangeraze.controller;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.service.AnalysisService;
import ru.orangeraze.service.CanvasjsChartService;

@Controller
@RequestMapping("/canvasjschart")
@RequiredArgsConstructor
public class CanvasjsChartController {

    private final CanvasjsChartService canvasjsChartService;

    private final AnalysisService analysisService;

    @RequestMapping(method = RequestMethod.GET)
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO, @RequestParam(value = "name") String name,
                      ModelMap modelMap) {
        List<AnalysisBO> analyzes = analysisService.getAllByName(userDetailsBO, name);
        List<String> dateList = new ArrayList<>(analyzes.size());
        List<String> valueList = new ArrayList<>(analyzes.size());
        analyzes.stream().sorted(Comparator.comparing(AnalysisBO::getDate)).filter(analysisBO -> analysisBO.getDate()!=null).forEach(analysisBO -> {
            dateList.add("\"" + analysisBO.getDate().toString() + "\"");
            valueList.add(analysisBO.getValue());
        });
        modelMap.addAttribute("dateList", dateList);
        modelMap.addAttribute("valueList", valueList);

        return "showAnalysis";
    }

}