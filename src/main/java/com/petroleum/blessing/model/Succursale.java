package com.petroleum.blessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "succursale")
public class Succursale {

	
	
	public Succursale() {
		
	}

	public Succursale(String nom, String adresse, String type, String boitePostale, String dateCreation,
			String responsable) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
		this.boitePostale = boitePostale;
		this.dateCreation = dateCreation;
		this.responsable = responsable;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBoitePostale() {
		return boitePostale;
	}

	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "boite_postale")
	private String boitePostale;
	
	@Column(name = "date_creation")
	private String dateCreation;
	
	@Column(name = "responsable")
	private String responsable;
}
