package in.ajay.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import in.ajay.entities.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Serializable> {

	
	public List<StateEntity> findBycountryId(Integer countryId);
}
