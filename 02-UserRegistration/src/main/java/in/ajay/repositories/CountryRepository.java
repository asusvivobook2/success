package in.ajay.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajay.entities.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Serializable> {

}
