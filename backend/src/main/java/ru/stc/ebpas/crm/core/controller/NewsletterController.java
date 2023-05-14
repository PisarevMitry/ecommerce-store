package ru.stc.ebpas.crm.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.stc.ebpas.crm.core.model.Newsletter;
import ru.stc.ebpas.crm.core.service.NewsletterService;

@RestController
@RequestMapping("api/v1/newsletter")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @PostMapping
    public String register(@RequestBody Newsletter newsletter){

        return newsletterService.register(newsletter);
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token){
        return newsletterService.confirmToken(token);
    }

}
