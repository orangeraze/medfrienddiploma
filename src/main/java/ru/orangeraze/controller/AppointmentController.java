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
import ru.orangeraze.bo.AppointmentBO;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.dto.AnalysisDTO;
import ru.orangeraze.dto.AppointmentDTO;
import ru.orangeraze.service.AnalysisService;
import ru.orangeraze.service.AppointmentService;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      Model model) {
        List<AppointmentBO> appointments = appointmentService.getAll(userDetailsBO);
        model.addAttribute("appointments", appointments);
        return "/appointment";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      @Valid AppointmentDTO appointmentDTO,
                      BindingResult bindingResult,
                      Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("errorMessages", errors);
            List<AppointmentBO> appointments = appointmentService.getAll(userDetailsBO);
            model.addAttribute("appointments", appointments);
            return "/appointment";
        }

        List<AppointmentBO> appointments = appointmentService.save(appointmentDTO, userDetailsBO);

        model.addAttribute("appointments", appointments);
        return "/appointment";
    }
}
