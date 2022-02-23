package in.ajay.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajay.entity.CitizenEntity;

public interface CitizenRegRepo extends JpaRepository<CitizenEntity, Serializable> {

}
