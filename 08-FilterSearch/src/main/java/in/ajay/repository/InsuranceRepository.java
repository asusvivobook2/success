package in.ajay.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import in.ajay.entities.InsurancePlansEntity;

public interface InsuranceRepository extends JpaRepository<InsurancePlansEntity, Serializable> {
	
	
	
	
	
}
