package com.petroleum.blessing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petroleum.blessing.exception.RessourceNotFoundException;
import com.petroleum.blessing.model.Produit;
import com.petroleum.blessing.model.Utilisateur;
import com.petroleum.blessing.repository.ProduitRepository;
import com.petroleum.blessing.repository.UtilisateurRepository;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/api/v1/blessing")
public class ProduitController {


	@Autowired
	private ProduitRepository produitRepository ;

	// liste des produits api rest
	@GetMapping("/produit")
	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}

	// ajouter un produit api rest
	@PostMapping("/produit")
	public Produit addproduit(@RequestBody Produit produit) {
		return produitRepository.save(produit);

	}

	// recuperer un produit par son id api rest
	@GetMapping("/produit/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
		Produit produit = produitRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de produit pour id:" + id));
		return ResponseEntity.ok(produit);
	}
	
	// update produit rest api
	@PutMapping("/produit/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitdetail){
		Produit produit = produitRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de produit pour id:" + id));
		
		produit.setCodeProduit(produitdetail.getCodeProduit());
		produit.setLibelle(produitdetail.getLibelle());
		produit.setTarifAchat(produitdetail.getTarifAchat());
		produit.setTarifVente(produitdetail.getTarifVente());

		Produit updatedproduit = produitRepository.save(produit);
		return ResponseEntity.ok(updatedproduit);
	}
	
	
	// supprimer produit rest api
	@DeleteMapping("/produit/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduit(@PathVariable Long id){
		Produit produit = produitRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de produit pour id:" + id));
		
		produitRepository.delete(produit);
		Map<String, Boolean> response = new HashMap<>();
		response.put("supprimé", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
