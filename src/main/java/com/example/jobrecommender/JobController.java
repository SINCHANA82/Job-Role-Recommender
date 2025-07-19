package com.example.jobrecommender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/recommend")
    public String recommendJob(
            @RequestParam String skill,
            @RequestParam String education,
            @RequestParam String interest,
            Model model) {

        String recommendedJob;

        // Very basic logic (can be replaced with ML or DB logic)
        if (skill.toLowerCase().contains("java") && interest.toLowerCase().contains("web")) {
            recommendedJob = "Full Stack Developer";
        } else if (skill.toLowerCase().contains("python") && education.toLowerCase().contains("bsc")) {
            recommendedJob = "Data Analyst";
        } else if (skill.toLowerCase().contains("c") || skill.toLowerCase().contains("c++")) {
            recommendedJob = "Embedded Systems Engineer";
        } else if (interest.toLowerCase().contains("design")) {
            recommendedJob = "UI/UX Designer";
        } else {
            recommendedJob = "Software Tester";
        }

        model.addAttribute("job", recommendedJob);
        return "result";
    }
}
