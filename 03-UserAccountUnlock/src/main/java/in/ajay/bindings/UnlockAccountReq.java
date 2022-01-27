package in.ajay.bindings;

import lombok.Data;

@Data
public class UnlockAccountReq {
	
	private String email;
	private String temppwd;
	private String newpwd;
	private String confirmPwd;

}
