package ru.orangeraze.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.bo.ChronologyBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.ChronologyDTO;
import ru.orangeraze.service.ChronologyService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/chronology")
@RequiredArgsConstructor
public class ChronologyController {

    private final ChronologyService chronologyService;


    @GetMapping
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      Model model) {
        List<ChronologyBO> chronologies = chronologyService.getAll(userDetailsBO);
        model.addAttribute("chronologies", chronologies);
        return "/chronology";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      @Valid ChronologyDTO chronologyDTO,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMessages", errors);
            List<ChronologyBO> chronologies = chronologyService.getAll(userDetailsBO);
            model.addAttribute("chronologies", chronologies);
            return "/chronology";
        }

        List<ChronologyBO> chronologies = chronologyService.save(chronologyDTO, userDetailsBO);

        model.addAttribute("chronologies", chronologies);
        return "/chronology";
    }

}
