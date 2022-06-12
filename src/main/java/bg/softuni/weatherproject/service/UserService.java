package bg.softuni.weatherproject.service;

import bg.softuni.weatherproject.bindingModel.UserLoginDto;
import bg.softuni.weatherproject.bindingModel.UserRegisterDto;
import bg.softuni.weatherproject.dao.UserRepository;
import bg.softuni.weatherproject.model.User;
import bg.softuni.weatherproject.session.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserSession userSession;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private static final String UNSUCCESSFUL_LOGIN_MESSAGE = "Username or password is incorrect!";

    public UserService(UserRepository userRepository, UserSession userSession, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserRegisterDto userModel) {
        String username = userModel.getUsername();
        if (!isUserRegistered(username)) {
            log.info(String.format("User with username %s already exists!", username));
            return;
        }

        if (!userModel.getPassword().equals(userModel.getConfirmPassword())) {
            log.info("Passwords do not match!");
            return;
        }

        User userEntity = modelMapper.map(userModel, User.class);
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
        this.userRepository.save(userEntity);

        bindUserSession(username, userModel.getFullName(), userModel.getEmail());
    }

    public boolean loginUser(UserLoginDto userModel) {
        String username = userModel.getUsername();
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        if (optionalUser.isEmpty()) {
            log.info(UNSUCCESSFUL_LOGIN_MESSAGE);
            return false;
        }
        User userEntity = optionalUser.get();

        if (!passwordEncoder.matches(userModel.getPassword(), userEntity.getPassword())) {
            log.info(UNSUCCESSFUL_LOGIN_MESSAGE);
            return false;
        }

        bindUserSession(username, userEntity.getFullName(), userEntity.getEmail());
        return true;
    }

    private void bindUserSession(String username, String fullName, String email) {
        userSession.setLoggedIn(true);
        userSession.setUsername(username);
        userSession.setFullName(fullName);
        userSession.setEmail(email);
    }

    private boolean isUserRegistered(String username) {
        return this.userRepository.findUserByUsername(username).isEmpty();
    }

    public void logout() {
        userSession.setLoggedIn(false);
        userSession.setUsername(null);
        userSession.setFullName(null);
        userSession.setEmail(null);
    }
}