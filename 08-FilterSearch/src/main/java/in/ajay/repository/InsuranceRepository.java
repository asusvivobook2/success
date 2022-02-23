package in.ajay.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ajay.entities.InsurancePlansEntity;

@Repository
public interface InsuranceRepository extends JpaRepository<InsurancePlansEntity, Serializable> {
	
	
	
	
	
}
