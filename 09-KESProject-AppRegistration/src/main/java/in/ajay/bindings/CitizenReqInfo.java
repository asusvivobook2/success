package in.ajay.bindings;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenReqInfo {
	
	private String fullName;
	private String emailId;
	private Long mobileNo;
	private String Gender;
	private Date DOB;
	private String SSN;
	private String citizenState;
	
	

}
