package ru.stc.ebpas.crm.core.controller;

import ru.stc.ebpas.crm.core.service.RegistrationService;
import ru.stc.ebpas.crm.core.model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationController {
    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody UserInfo userInfo){
        return registrationService.register(userInfo);
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }


}
