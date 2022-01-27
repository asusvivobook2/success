package in.ajay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ajay.bindings.LoginReq;
import in.ajay.service.LoginService;

@RestController
public class LoginAccountRest {

	@Autowired
	private LoginService service;

	@GetMapping("/login/{email}")
	public String LoginRest(LoginReq req) {
		return service.Login(req);
        
	}
}
