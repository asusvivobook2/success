package in.ajay.bindings;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class User {

	private Integer userId;

	private String userFname;
	private String userLname;
	private String userEmail;
	private Long userPhno;
	private Date userDOB;
	private String userGender;
	private Integer userCountry;
	private Integer userState;
	private Integer userCity;
	private String userAccStatus;
	private String userPwd;
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
