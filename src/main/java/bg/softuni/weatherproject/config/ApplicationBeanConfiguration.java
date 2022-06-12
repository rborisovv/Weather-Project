package bg.softuni.weatherproject.config;

import bg.softuni.weatherproject.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @SessionScope
    public UserSession userSession() {
        return new UserSession();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}