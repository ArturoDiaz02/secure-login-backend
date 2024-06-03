package com.login.secureloginbackend.application.port.input;

import com.login.secureloginbackend.domain.dto.request.ChangePasswordDTO;
import com.login.secureloginbackend.domain.dto.request.LoginDTO;
import com.login.secureloginbackend.domain.dto.request.SignUpDTO;
import com.login.secureloginbackend.domain.dto.response.TokenDTO;
import com.login.secureloginbackend.domain.dto.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServicePort {
    TokenDTO login(LoginDTO loginDTO);
    TokenDTO save(SignUpDTO user);
    UserResponseDTO getUser(String email);
    Long countUsers(String token);
    Boolean validateUserRoleIsAdmin(String token);
    ResponseEntity<String> deleteUser(String email, String token);
    UserResponseDTO changePassword(ChangePasswordDTO changePasswordDTO, String token);
    List<UserResponseDTO> getAllUsers(String token);
}
