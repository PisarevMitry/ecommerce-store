package ru.stc.ebpas.crm.core.service;

import ru.stc.ebpas.crm.core.config.JwtProvider;
import ru.stc.ebpas.crm.core.model.LoginRequest;
import ru.stc.ebpas.crm.core.model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginService {
    private final EmailValidator emailValidator;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserInfoService userInfoService;

    public String login(LoginRequest req){
        if(!emailValidator.test(req.getEmail())){
            throw  new IllegalArgumentException("invalid email address");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
            UserInfo userInfo = (UserInfo)userInfoService.loadUserByUsername(req.getEmail());
            return jwtProvider.createToken(req.getEmail(), List.of(userInfo.getUserRole()));
        }catch (Exception e){
            throw new IllegalStateException("invalid username/password provided");
        }
    }
}
