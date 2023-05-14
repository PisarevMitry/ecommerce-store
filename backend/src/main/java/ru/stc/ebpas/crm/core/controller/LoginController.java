package ru.stc.ebpas.crm.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.stc.ebpas.crm.core.model.LoginRequest;
import ru.stc.ebpas.crm.core.service.LoginService;

@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {
    private final LoginService loginService;
    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
