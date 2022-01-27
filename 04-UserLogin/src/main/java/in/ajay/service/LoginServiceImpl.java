package in.ajay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajay.bindings.LoginReq;
import in.ajay.entities.UserEntity;
import in.ajay.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String Login(LoginReq req) {
		UserEntity user = userRepo.findByUserEmailAndUserPwd(req.getEmail(), req.getUserPwd());
		if (user != null) {
			return "Login Successful";

		}
		return "Login Failed::Invalid Credintials";
	}

}
