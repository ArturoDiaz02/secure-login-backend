package com.login.secureloginbackend.infrastructure.adapter.persistence;

import com.login.secureloginbackend.application.port.output.UserPersistencePort;
import com.login.secureloginbackend.domain.model.Role;
import com.login.secureloginbackend.domain.model.UserModel;
import com.login.secureloginbackend.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;

    @Override
    public boolean findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserModel> findUserModelByEmail(String email) {
        return userRepository.findUserModelByEmail(email);
    }

    @Override
    public Optional<UserModel> findUserModelByRole(Role role) {
        return userRepository.findUserModelByRole(role);
    }

    @Override
    public void updatePassword(String email, String password) {
        userRepository.updatePassword(email, password);
    }

    @Override
    public void save(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
}
