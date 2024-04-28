package ru.litavrina.mvc_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.litavrina.mvc_thymeleaf.model.UserFairyTaleProfile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class helloController {
    @RequestMapping("/hello")
    public String sayHello(Model model) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        model.addAttribute("today", formattedDate);
        return "hello.html";
    }

    @GetMapping("/hello/input")
    public String inputHello(Model model) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        model.addAttribute("today", formattedDate);

        return "inputHello.html";
    }

    @PostMapping("/hello/input")
    public String setFairyTaleCharacterMsg(UserFairyTaleProfile userFairyTaleProfile,
                                           Model model) {
        StringBuilder thanksgiving = new StringBuilder();

//        Если чекбокс отмечен
        if (userFairyTaleProfile.isBelieveInMiracles()) {
            thanksgiving.append("Так хорошо что вы верите в чудеса!");
        }
//        Если в тексте есть слово хочу
        if (userFairyTaleProfile.getMsg().toLowerCase().contains("хочу")) {
            thanksgiving.append("Ваше желание обязательно сбудется!");
        }
        thanksgiving.append(userFairyTaleProfile.getName())
                .append(" очень благодарен вам за письмо! Скзочные герои живут только тогда, когда кто-то о них думает.");
        model.addAttribute("thanksgiving", thanksgiving);
        return "thanksgiving.html";
    }
}
