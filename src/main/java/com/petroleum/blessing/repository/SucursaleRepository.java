package com.petroleum.blessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petroleum.blessing.model.Succursale;
import com.petroleum.blessing.model.Utilisateur;

	
	@Repository
	public interface SucursaleRepository extends JpaRepository<Succursale, Long> {

}
