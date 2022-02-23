package in.ajay.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="INSURANCE_PLANS")
@Entity
public class InsurancePlansEntity {
	
	@Id
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "HOLDER_NAME")
	private String holderName;
	
	@Column(name = "HOLDER_SSN")
	private long holderSsn;
	
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	

}
