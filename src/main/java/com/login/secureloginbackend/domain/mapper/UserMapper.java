package com.login.secureloginbackend.domain.mapper;


import com.login.secureloginbackend.domain.dto.request.LoginDTO;
import com.login.secureloginbackend.domain.dto.request.SignUpDTO;
import com.login.secureloginbackend.domain.dto.response.UserResponseDTO;
import com.login.secureloginbackend.domain.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel fromLoginDTO(LoginDTO loginDTO);
    UserModel fromUserDTO(SignUpDTO signUpDTO);
    UserResponseDTO fromUser(UserModel userModel);

}
