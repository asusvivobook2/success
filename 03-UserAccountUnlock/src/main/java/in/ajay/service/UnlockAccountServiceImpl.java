package in.ajay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajay.bindings.UnlockAccountReq;
import in.ajay.entities.UserEntity;
import in.ajay.repositories.UserRepository;

@Service
public class UnlockAccountServiceImpl implements UserUnlockService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String UnlockAccount(UnlockAccountReq req) {
		UserEntity user = userRepo.findByUserEmailAndUserPwd(req.getEmail(), req.getTemppwd());
		if (user != null) {
			user.setUserPwd(req.getConfirmPwd());
			user.setUserAccStatus("Unlocked");
			userRepo.save(user);
			return "Account Unlocked SuccessFully";

		}
		return "Invalid TemporaryPassword";
	}

}
