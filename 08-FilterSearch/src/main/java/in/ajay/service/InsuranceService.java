package in.ajay.service;

import java.util.List;

import in.ajay.bindings.PlanRequest;
import in.ajay.bindings.PlanResponse;

public interface InsuranceService {

	public List<PlanResponse> SearchAll(PlanRequest request);
}
