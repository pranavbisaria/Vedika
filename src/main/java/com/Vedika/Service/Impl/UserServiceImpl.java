package com.Vedika.Service.Impl;
import com.Vedika.Exceptions.ResourceNotFoundException;
import com.Vedika.Model.Role;
import com.Vedika.Model.User;
import com.Vedika.Payload.ApiResponse;
import com.Vedika.Payload.UserDto;
import com.Vedika.Repository.UserRepo;
import com.Vedika.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<?> save(UserDto userDto){
        userDto.setFirstName(userDto.getFirstName().trim());
        userDto.setLastName(userDto.getLastName().trim());
        userDto.setEmail(userDto.getEmail().trim().toLowerCase());
        User user = this.modelMapper.map(userDto, User.class);
        user.getRoles().add(new Role("ROLE_ADMIN"));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        this.userRepo.save(user);
        return new ResponseEntity<>(new ApiResponse("User has been Successfully Registered", true), OK);
    }
}
