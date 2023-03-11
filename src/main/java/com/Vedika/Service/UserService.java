package com.Vedika.Service;

import com.Vedika.Payload.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> save(UserDto userDto);
}
