package in.ajay.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajay.bindings.User;
import in.ajay.entities.CityEntity;
import in.ajay.entities.CountryEntity;
import in.ajay.entities.StateEntity;
import in.ajay.entities.UserEntity;
import in.ajay.repositories.CityRepository;
import in.ajay.repositories.CountryRepository;
import in.ajay.repositories.StateRepository;
import in.ajay.repositories.UserRepository;
import in.ajay.util.EmailUtils;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean uniqueEmail(String userEmail) {
		UserEntity userEntity = userRepo.findByuserEmail(userEmail);

		// return userEntity==null;

		if (userEntity == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryEntity> findall = countryRepo.findAll();

		Map<Integer, String> countrymap = new HashMap<Integer, String>();
		for (CountryEntity countryEntity : findall) {
			countrymap.put(countryEntity.getCountryId(), countryEntity.getCountryName());

		}
		return countrymap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateEntity> countryList = stateRepo.findBycountryId(countryId);

		Map<Integer, String> stateMap = new HashMap<Integer, String>();
		for (StateEntity stateEntity : countryList) {
			stateMap.put(stateEntity.getCountryId(), stateEntity.getStateName());
		}

		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityEntity> citiesList = cityRepo.findBystateId(stateId);
		Map<Integer, String> cityMap = new HashMap<Integer, String>();

		for (CityEntity cityEntity : citiesList) {

			cityMap.put(cityEntity.getCityId(), cityEntity.getCityName());
		}

		return cityMap;
	}

	@Override
	public boolean RegisterUser(User user) {
		user.setUserPwd(getAlphaNumericString());
		user.setUserAccStatus("LOCKED");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity save = userRepo.save(userEntity);
		if (userEntity.getUserId() != null) {
			return sendRegMail(user);
		}

		// TODO Auto-generated method stub
		return false;
	}

	private static String getAlphaNumericString() {
		int n = 8;
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int genwratedPas = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(genwratedPas));
		}

		return sb.toString();
	}

	private boolean sendRegMail(User user) {
		boolean mailStatus = false;
		String subject = "UserRegistration Success";
		String bodydata = mailBody("EMAIL_BODY_TEXT.txt", user);

		mailStatus = emailUtils.sendEmail(subject, bodydata, user.getUserEmail());
		return mailStatus;

	}

	public String mailBody(String fileName, User user) {
		String bodydata = null;
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(fileName);
		try (Stream<String> stream = Files.lines(path)) {

			stream.forEach(line -> {
				buffer.append(line);
			});

			bodydata = buffer.toString();

			bodydata = bodydata.replace("{FNAME}", user.getUserFname());
			bodydata = bodydata.replace("{EMAIL}", user.getUserEmail());
			bodydata = bodydata.replace("{TEMP-PWD}", user.getUserPwd());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bodydata;
	}

}
