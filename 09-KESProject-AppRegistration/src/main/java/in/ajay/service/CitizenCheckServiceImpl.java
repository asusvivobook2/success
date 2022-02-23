package in.ajay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ajay.bindings.CitizenReqInfo;
import in.ajay.entity.CitizenEntity;
import in.ajay.repository.CitizenRegRepo;

@Service
public class CitizenCheckServiceImpl implements CitizenEligibilityService {
	@Autowired
	private CitizenRegRepo repo;

	private static String state = null;

	@Override
	public String Citizenshipcheck(CitizenReqInfo info) {
		String url = "https://ssa-web-api.herokuapp.com/state/{ssn}" + info.getSSN();
		RestTemplate temp = new RestTemplate();
		state = temp.getForObject(url, String.class, info.getSSN());
		if (state.equals("Kentucky")) {
			this.CitizenDataInsertion(info);
			return "CitizenRegistration Successfull" + "--------->" + state;
		}

		return "CitizenRegistration Failed";

	}

	private void CitizenDataInsertion(CitizenReqInfo info) {
		CitizenEntity entity = new CitizenEntity();
		BeanUtils.copyProperties(info, entity);
		entity.setApplicationRegNo(this.RegNumGenerte());
		entity.setCitizenState(state);
		repo.save(entity);

	}

	@Override
	public List<CitizenReqInfo> FetchCitizenData() {
		List<CitizenReqInfo> datalist = new ArrayList<>();

		List<CitizenEntity> find = repo.findAll();

		for (CitizenEntity entity : find) {

			CitizenReqInfo req = new CitizenReqInfo();
			BeanUtils.copyProperties(entity, req);
			datalist.add(req);

		}

		return datalist;
	}

	private String RegNumGenerte() {
		Random r = new Random();
		String randomNumber = String.format("%04d", r.nextInt(1001));
		String regno = "AR" + randomNumber;
		System.out.println(regno);
		return regno;
	}

}// class
