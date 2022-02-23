package in.ajay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ajay.bindings.CitizenReqInfo;
import in.ajay.service.CitizenEligibilityService;

@RestController
public class AppRegRest {

	@Autowired
	private CitizenEligibilityService service;

	@PostMapping("/check")
	public String CheckCitizen(@RequestBody CitizenReqInfo info) {
		System.out.println(info.getSSN());
		return service.Citizenshipcheck(info);
		 
	}
	@GetMapping("/getdata")
	public List<CitizenReqInfo> FetchDtls(){
		return service.FetchCitizenData();
	}
}
