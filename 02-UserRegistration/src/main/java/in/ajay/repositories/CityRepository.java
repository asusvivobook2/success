package in.ajay.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajay.entities.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Serializable> {

	public List<CityEntity> findBystateId(Integer stateId);
	
	
}
