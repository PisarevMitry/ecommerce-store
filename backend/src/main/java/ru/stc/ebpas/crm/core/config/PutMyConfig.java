package ru.stc.ebpas.crm.core.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.stc.ebpas.crm.core.model.UserInfo;
import ru.stc.ebpas.crm.core.model.UserRole;
import ru.stc.ebpas.crm.core.repository.UserInfoRepository;

@Configuration
public class PutMyConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserInfoRepository userInfoRepository){
        return args -> {
            UserInfo u1 = new UserInfo(
                 "Pisarev",
                 "Dmitrii",
                 "d.pisarev.03@gmail.com",
                 new BCryptPasswordEncoder().encode("password"),
                    UserRole.ADMIN,
                    true
            );
            userInfoRepository.save(u1);
        };
    }
}
