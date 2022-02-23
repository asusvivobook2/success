package in.ajay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "CITIZEN_REG_DTLS")
@Entity
public class CitizenEntity {
	
	@GeneratedValue
	@Column(name="APPLICATION_NO")
	private Integer applicationNo;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NO")
	private Long mobileNo;
	
	@Column(name = "GENDER")
	private String Gender;
	
	@Column(name = "DOB")
	private Date DOB;
	
	@Column(name = "SSN")
	private String SSN;
	
	@Id
	@Column(name = "APPLIACATIONREG_NO")
	private String applicationRegNo;
	
	@Column(name="CITIZEN_STATE")
	private String citizenState;
	
	

}
