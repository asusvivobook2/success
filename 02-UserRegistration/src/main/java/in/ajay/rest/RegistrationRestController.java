package in.ajay.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ajay.bindings.User;
import in.ajay.service.RegistrationService;

@RestController
public class RegistrationRestController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/checkemail/{userEmail}")
	public String checkEmail(@PathVariable String userEmail) {

		boolean uniqueEmail = registrationService.uniqueEmail(userEmail);
		if (uniqueEmail) {
			return "UNIQUE";
		} else {

			return "DUPLICATE";
		}

	}

	@GetMapping("/countries")
	public Map<Integer, String> fetchCountries() {
		return registrationService.getCountries();

	}

	@GetMapping("/states/{countryId}")
	public Map<Integer, String> fetchStates(@PathVariable Integer countryId) {
		return registrationService.getStates(countryId);
	}

	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> fetchCities(@PathVariable Integer stateId) {
		return registrationService.getCities(stateId);

	}
@PostMapping("/saveuser")
	public String saveUser(@RequestBody User user) {

		boolean registerUser = registrationService.RegisterUser(user);
		
		if (registerUser=true) {
			return " Sign Up Successful";
		} else {
			return " Sign Up Failed";
		}
	}

}
