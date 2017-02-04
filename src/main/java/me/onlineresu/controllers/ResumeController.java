package me.onlineresu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    @GetMapping(value = "/")
    public String resume() {
        return "resume";
    }
}
