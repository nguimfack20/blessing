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
import com.petroleum.blessing.model.Compte;
import com.petroleum.blessing.repository.CompteRepository;


@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/api/v1/blessing")
public class CompteController {

	@Autowired
	private CompteRepository compteRepository  ;

	// liste des comptes api rest
	@GetMapping("/compte")
	public List<Compte> getAllCompte() {
		return compteRepository.findAll();
	}

	// ajouter un compte api rest
	@PostMapping("/compte")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteRepository.save(compte);

	}

	// recuperer un compte par son id api rest
	@GetMapping("/compte/{id}")
	public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
		Compte compte = compteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de compte pour id:" + id));
		return ResponseEntity.ok(compte);
		
	}
	
	// update compte rest api
	@PutMapping("/compte/{id}")
	public ResponseEntity<Compte> updateCompte(@PathVariable Long id, @RequestBody Compte comptedetail){
		Compte compte = compteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de compte pour id:" + id));
		
		
		compte.setAgenceCreation(comptedetail.getAgenceCreation());
		compte.setDateCreation(comptedetail.getDateCreation());
		compte.setDateExpiration(comptedetail.getDateExpiration());
		compte.setDescription(comptedetail.getDescription());
		compte.setMatriculeClient(comptedetail.getMatriculeClient());
		compte.setNumeroCompte(comptedetail.getNumeroCompte());
		compte.setSolde(comptedetail.getSolde());
		
		Compte updatedcompte = compteRepository.save(compte);
		return ResponseEntity.ok(updatedcompte);


	}
	
	
	// supprimer compte rest api
	@DeleteMapping("/compte/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCompte(@PathVariable Long id){
		Compte compte = compteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de compte pour id:" + id));
		
		compteRepository.delete(compte);
		Map<String, Boolean> response = new HashMap<>();
		response.put("supprimé", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
