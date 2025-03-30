package com.app.register.controller; 

/* 
import jakarta.validation.Valid; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestBody; 
*/  

// Import necessary Spring and Java classes
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.ui.Model; 

import com.app.register.service.UserService; 
import com.app.register.dto.UserDto; 

/**
 * Controller annotation indicates this class handles 
 * web requests and returns views. Use RestController 
 * annotation to call APIs, return as JSON data 
 */ 
@Controller   
@RequestMapping("/users") // Base path for all routes in this controller
public class UserController {

		private final UserService userservice;

		// Constructor-based dependency injection for UserService
		@Autowired 
		public UserController(UserService userservice) {
			this.userservice = userservice; 
		}

		/**
     	* Handles GET requests for the registration page.
     	* Adds an empty UserDto object to the model to bind form data.
     	* @param model Spring's Model object to pass data to the view.
     	* @return "register" - the name of the Thymeleaf template to display.
     	*/
		@GetMapping("/register") 
		public String showRegisterationForm(Model model) { 
				
				// Add empty UserDto to the model
				model.addAttribute("user", new UserDto()); 
				return "register"; 
		}


		/*@PostMapping("/register")
		public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto){
			userservice.registerUser(userDto);
			return ResponseEntity.ok("User Registered Successfully");
		}*/ 

		/**
     	* Handles POST requests for user registration.
     	* Receives form data, registers the user, and returns a success page.
     	* @param userDto The form data submitted by the user, automatically mapped to UserDto.
     	* @param model Model object to pass data to the success page.
     	* @return "success" - the name of the success page template.
     	*/
		@PostMapping("/register") 
		public String registerUser(@ModelAttribute("user") UserDto userDto, Model model) 
		{
        	userservice.registerUser(userDto); // Call service to save user
        	model.addAttribute("message", "User Registered Successfully!");
        	return "success"; // Redirect to success.html
    	}

    	/**
     	* Handles GET requests for the success page.
     	* @return "success" - the name of the success page template.
     	*/
		@GetMapping("/success") 
		public String showSuccessPage() { 
			return "success"; 
		} 
}