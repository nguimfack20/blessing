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
import com.petroleum.blessing.model.Succursale;
import com.petroleum.blessing.repository.ProduitRepository;
import com.petroleum.blessing.repository.SucursaleRepository;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/api/v1/blessing")
public class SuccursaleController {


	@Autowired
	private SucursaleRepository sucursaleRepository ;

	// liste des succursales api rest
	@GetMapping("/succursale")
	public List<Succursale> getAllSuccursale() {
		return sucursaleRepository.findAll();
	}

	// ajouter une succursale api rest
	@PostMapping("/succursale")
	public Succursale addSuccursale(@RequestBody Succursale succursale) {
		return sucursaleRepository.save(succursale);

	}

	// recuperer une succursale par son id api rest
	@GetMapping("/succursale/{id}")
	public ResponseEntity<Succursale> getSuccursaleById(@PathVariable Long id) {
		Succursale succursale = sucursaleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de succursale pour id:" + id));
		return ResponseEntity.ok(succursale);
	}
	
	// update succursale rest api
	@PutMapping("/succursale/{id}")
	public ResponseEntity<Succursale> updateSuccursale(@PathVariable Long id, @RequestBody Succursale succursaledetail){
		Succursale succursale = sucursaleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de sucursale pour id:" + id));
		
		succursale.setAdresse(succursaledetail.getAdresse());
		succursale.setBoitePostale(succursaledetail.getBoitePostale());
		succursale.setDateCreation(succursaledetail.getDateCreation());
		succursale.setNom(succursaledetail.getNom());
		succursale.setResponsable(succursaledetail.getResponsable());
		succursale.setType(succursaledetail.getType());

		Succursale updatedsuccursale = sucursaleRepository.save(succursale);
		return ResponseEntity.ok(updatedsuccursale);
	}
	
	
	// supprimer succursale rest api
	@DeleteMapping("/succursale/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSuccursale(@PathVariable Long id){
		Succursale succursale = sucursaleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("il nexiste pas de succursale pour id:" + id));
		
		sucursaleRepository.delete(succursale);
		Map<String, Boolean> response = new HashMap<>();
		response.put("supprimé", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
