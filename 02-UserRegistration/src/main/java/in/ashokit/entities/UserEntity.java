package in.ashokit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="user_dtls")
public class UserEntity {

	@GeneratedValue
	@Id
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_FIRST_NAME")
	private String userFname;
	
	@Column(name="USER_LAST_NAME")
	private String userLname;
	
	@Column(name="USER_EMAIL",unique = true)
	private String userEmail;
	
	@Column(name="USER_PHNO")
	private Long userPhno;
	
	@Column(name="USER_DOB")
	private Date userDOB;
	
	@Column(name="USER_GENDER")
	private String userGender;
	
	@Column(name="USER_COUNTRY")
	private Integer userCountry;
	
	@Column(name="USER_STATE")
	private Integer userState;
	
	@Column(name="USER_CITY")
	private Integer userCity;
	
	@Column(name="USER_PWD")
	private String userPwd;
	
	@Column(name="USER_ACC_STATUS")
	private String userAccStatus;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

}
