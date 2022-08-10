package com.petroleum.blessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petroleum.blessing.model.Compte;


	
	@Repository
	public interface CompteRepository extends JpaRepository<Compte, Long> {

}
