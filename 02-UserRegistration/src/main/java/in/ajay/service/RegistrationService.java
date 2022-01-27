package in.ajay.service;

import java.util.Map;

import in.ajay.bindings.User;

public interface RegistrationService {

	public boolean uniqueEmail(String userEmail);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public boolean RegisterUser(User user);

}
