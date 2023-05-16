package pl.opole.uni.springWebApp.controllers;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.repositories.RoleRepository;
//import pl.opole.uni.springWebApp.services.UserService;

@RestController
public class UserController {

//    private final UserService userService;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserController(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    //@GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    //@PostMapping("/register")
//    public ModelAndView registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        ModelAndView mav = new ModelAndView();
//System.out.println("testttttttttttt");
//        if (bindingResult.hasErrors()) {
//            mav.setViewName("register");
//            return mav;
//        }
//
//        if (userService.findByUsername(user.getUsername()) != null) {
//            bindingResult.rejectValue("username", "error.user",
//                    "Użytkownik o podanej nazwie już istnieje");
//            mav.setViewName("register");
//            return mav;
//        }
//
//        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
//        user.setEnabled(true);
//        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
//        
//        try {
//            userService.saveUser(user);
//            //mav.setViewName("redirect:/login?success");
//            return mav;
//        } catch (Exception e) {
//            mav.addObject("errorMessage", "Wystąpił błąd podczas zapisywania użytkownika.");
//            mav.setViewName("register");
//            return mav;
//        }
//    }
//    
//    //@GetMapping("/login")
//    public String login() {
//    	return "login";
//    }
	
	
//	 <dependency>
//	    <groupId>org.springframework.boot</groupId>
//	    <artifactId>spring-boot-starter-security</artifactId>
//	           </dependency>       
//	           
//	           <dependency>
//	                     <groupId>org.springframework.security</groupId>
//	                     <artifactId>spring-security-crypto</artifactId>
//	                     <version>5.6.0</version>
//	          </dependency>    
}
