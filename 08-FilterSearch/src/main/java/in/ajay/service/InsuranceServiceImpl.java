package in.ajay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ajay.bindings.PlanRequest;
import in.ajay.bindings.PlanResponse;
import in.ajay.entities.InsurancePlansEntity;
import in.ajay.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceRepository repo;

	@Override
	public List<PlanResponse> SearchAll(PlanRequest request) {
		InsurancePlansEntity entity = new InsurancePlansEntity();
		if (request.getPlanName() != null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		Example<InsurancePlansEntity> example = Example.of(entity);
		List<InsurancePlansEntity> find = repo.findAll(example);
		System.out.println(find);
		List<PlanResponse> res = new ArrayList<>();
		System.out.println(res);
		for (InsurancePlansEntity planentity : find) {
			System.out.println(find);
			PlanResponse presp = new PlanResponse();
			BeanUtils.copyProperties(planentity, presp);
			res.add(presp);
			
			
		}
		return res;
	}

}
