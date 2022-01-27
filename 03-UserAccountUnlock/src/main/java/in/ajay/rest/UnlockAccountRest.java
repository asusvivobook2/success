package in.ajay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ajay.bindings.UnlockAccountReq;
import in.ajay.service.UserUnlockService;

@RestController
public class UnlockAccountRest {

	@Autowired
	private UserUnlockService service;

	@PostMapping("/unlock/{userEmail}")
	public String UnlockRest(@RequestBody UnlockAccountReq req) {

		return service.UnlockAccount(req);

	}

}
