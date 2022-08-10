package com.petroleum.blessing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
import com.petroleum.blessing.model.Utilisateur;
import com.petroleum.blessing.repository.UtilisateurRepository;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/api/v1/blessing")
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	// liste des utilisateurs api rest
	@GetMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	// ajouter un utilisateur api rest
	@PostMapping("/utilisateur")
	public Utilisateur addutilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);

	}

	// recuperer un utilisateur par son id api rest
	@GetMapping("/utilisateur/{id}")
	public ResponseEntity<Utilisateur> getutilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas dutilisateur pour id:" + id));
		return ResponseEntity.ok(utilisateur);
	}
	// update employee rest api
	
	@PutMapping("/utilisateur/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurdetail){
		Utilisateur utilisateur = utilisateurRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas dutilisateur pour id:" + id));
		
		utilisateur.setAdresse(utilisateurdetail.getAdresse());
		utilisateur.setActif(utilisateurdetail.getActif());
		utilisateur.setDateNaissance(utilisateurdetail.getDateNaissance());
		utilisateur.setEmail(utilisateurdetail.getEmail());
		utilisateur.setNom(utilisateurdetail.getNom());
		utilisateur.setMatricule(utilisateurdetail.getMatricule());

		utilisateur.setNumeroCni(utilisateurdetail.getNumeroCni());

		utilisateur.setPassword(utilisateurdetail.getPassword());

		utilisateur.setRole(utilisateurdetail.getRole());

		utilisateur.setTelephone(utilisateurdetail.getTelephone());
		utilisateur.setZoneTravail(utilisateurdetail.getZoneTravail());
        Utilisateur updateduUtilisateur = utilisateurRepository.save(utilisateur);
		return ResponseEntity.ok(updateduUtilisateur);
	}
	
	
	// supprimer utilisateur rest api
	@DeleteMapping("/utilisateur/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUtilisateur(@PathVariable Long id){
		Utilisateur utilisateur = utilisateurRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas dutilisateur pour id:" + id));
		
						utilisateurRepository.delete(utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("supprimé", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
