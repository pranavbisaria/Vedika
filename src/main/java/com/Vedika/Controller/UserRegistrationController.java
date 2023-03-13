package com.Vedika.Controller;

import com.Vedika.Payload.UserDto;
import com.Vedika.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }
	
//	@GetMapping
//	public String showRegistrationForm() {
//		return "registration";
//	}
	
//	@PostMapping
//	public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
//		userService.save(userDto);
//		return "redirect:/registration?success";
//	}
}
