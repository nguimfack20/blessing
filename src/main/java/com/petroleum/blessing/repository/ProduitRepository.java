package com.petroleum.blessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petroleum.blessing.model.Produit;
import com.petroleum.blessing.model.Utilisateur;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
