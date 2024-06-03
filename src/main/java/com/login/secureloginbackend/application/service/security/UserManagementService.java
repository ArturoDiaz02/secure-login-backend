package com.login.secureloginbackend.application.service.security;


import com.login.secureloginbackend.application.port.output.UserPersistencePort;
import com.login.secureloginbackend.infrastructure.repository.UserRepository;
import com.login.secureloginbackend.domain.model.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userManagementService")
@AllArgsConstructor
public class UserManagementService implements UserDetailsService {

    private final UserPersistencePort repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findUserModelByEmail(email).map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("User not found: "+ email));
    }
}
