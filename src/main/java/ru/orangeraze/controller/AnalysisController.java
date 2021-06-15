package ru.orangeraze.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.AnalysisDTO;
import ru.orangeraze.service.AnalysisService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      Model model) {
        List<AnalysisBO> analyzes = analysisService.getAll(userDetailsBO);
        model.addAttribute("analyzes", analyzes);
        return "/analysis";
    }

    @GetMapping("/name")
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO, @RequestParam(value = "name") String name,
                      Model model) {
        List<AnalysisBO> analyzes = analysisService.getAllByName(userDetailsBO, name);
        model.addAttribute("analyzes", analyzes);
        List<String> dateList = new ArrayList<>(analyzes.size());
        List<String> valueList = new ArrayList<>(analyzes.size());
        List<String> minNormList = new ArrayList<>(analyzes.size());
        List<String> maxNormList = new ArrayList<>(analyzes.size());
        analyzes.stream().sorted(Comparator.comparing(AnalysisBO::getDate)).forEach(analysisBO -> {
            dateList.add("\"" + analysisBO.getDate().toString() + "\"");
            valueList.add(analysisBO.getValue());
            minNormList.add(analysisBO.getMinnorm());
            maxNormList.add(analysisBO.getMaxnorm());
        });
        model.addAttribute("dateList", dateList);
        model.addAttribute("valueList", valueList);
        model.addAttribute("minNormList", minNormList);
        model.addAttribute("maxNormList", maxNormList);
        return "/showAnalysis";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      @Valid AnalysisDTO analysisDTO,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMessages", errors);
            List<AnalysisBO> analyzes = analysisService.getAll(userDetailsBO);
            model.addAttribute("analyzes", analyzes);
            return "/analysis";
        }

        List<AnalysisBO> analyzes = analysisService.save(analysisDTO, userDetailsBO);

        model.addAttribute("analyzes", analyzes);
        return "/analysis";
    }
}
