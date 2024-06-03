package com.login.secureloginbackend.infrastructure.config;

import com.login.secureloginbackend.domain.model.Role;
import com.login.secureloginbackend.domain.model.UserModel;
import com.login.secureloginbackend.infrastructure.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class DatabaseInitializerConfig {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseInitializerConfig(UserRepository userRepository,
                                     @Qualifier("passwordEncodeService") PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Este método se ejecuta cuando la aplicación se inicia
     */
    @PostConstruct
    public void initialize() {
        if (!adminUserExists()) {
            createAdminUser();
        }
    }

    /**
     * Este método verifica si existe un usuario administrador en la base de datos
     * @return true si existe, false si no existe
     */
    private boolean adminUserExists() {
        return userRepository.findUserModelByRole(Role.ADMIN).isPresent();

    }

    /**
     * Este método crea un usuario administrador en la base de datos
     */
    private void createAdminUser() {
        UserModel adminUser = UserModel.builder()
                .userId(UUID.randomUUID())
                .firstName("Arturo")
                .lastName("Diaz")
                .email("admin@gmail.com")
                .role(Role.ADMIN)
                .password(passwordEncoder.encode("UID2ijkfsdK"))
                .lastLogin(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
                .build();

        userRepository.save(adminUser);
    }
}

