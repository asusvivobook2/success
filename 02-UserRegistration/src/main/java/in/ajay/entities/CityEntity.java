package in.ajay.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="city_master")
public class CityEntity {
	
	@Id
	@Column(name = "CITY_ID")
	private Integer cityId;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@Column(name = "STATE_ID")
	private Integer stateId;
	

}
