package ru.stc.ebpas.crm.core.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ping")
public class Content {
    @GetMapping
    public String resp(){
        return "pong";
    }

    @GetMapping("protected")
    public String errorRoute(){
        return "pong";
    }
}
