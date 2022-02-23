package in.ajay.service;

import java.util.List;

import in.ajay.bindings.CitizenReqInfo;

public interface CitizenEligibilityService {
	public String Citizenshipcheck(CitizenReqInfo info);
	public List<CitizenReqInfo> FetchCitizenData();

}
