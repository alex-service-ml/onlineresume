package me.onlineresu.controllers;

import me.onlineresu.data.models.ResumeModel;
import me.onlineresu.dto.ResumeDTO;
import me.onlineresu.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    private final ResumeService resumeService;
    private final ConversionService conversionService;
    @Autowired
    public ResumeController(ResumeService resumeService, ConversionService conversionService) {
        this.resumeService = resumeService;
        this.conversionService = conversionService;
    }

    @GetMapping(value = "/")
    public String resume(Model model) {
        ResumeModel resume = resumeService.getResume();
        model.addAttribute("resume", conversionService.convert(resume, ResumeDTO.class));
        return "resume";
    }
}
