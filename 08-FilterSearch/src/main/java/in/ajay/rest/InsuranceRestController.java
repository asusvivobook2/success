package in.ajay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ajay.bindings.PlanRequest;
import in.ajay.bindings.PlanResponse;
import in.ajay.service.InsuranceService;

@RestController
public class InsuranceRestController {

	@Autowired
	private InsuranceService service;

	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> SearchPlan(@RequestBody PlanRequest request) {
		List<PlanResponse> search = service.SearchAll(request);
		
		return new ResponseEntity<>(search, HttpStatus.OK);

	}

}
