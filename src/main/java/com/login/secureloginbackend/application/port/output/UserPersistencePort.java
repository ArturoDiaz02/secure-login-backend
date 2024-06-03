package com.login.secureloginbackend.application.port.output;

import com.login.secureloginbackend.domain.model.Role;
import com.login.secureloginbackend.domain.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    boolean findByEmail(String email);
    Optional<UserModel> findUserModelByEmail(String email);
    Optional<UserModel> findUserModelByRole(Role role);
    void updatePassword(String email, String password);
    void save(UserModel userModel);
    long count();
    void delete(UserModel userModel);
    List<UserModel> findAll();
}
