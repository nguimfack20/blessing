package com.petroleum.blessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "numero_compte")
	private String numeroCompte;

	@Column(name = "matricule_client")
	private String matriculeClient;

	@Column(name = "date_creation")
	private String dateCreation;

	@Column(name = "date_expiration")
	private String dateExpiration;

	@Column(name = "solde")
	private String solde;

	@Column(name = "agence_creation")
	private String agenceCreation;

	@Column(name = "description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getMatriculeClient() {
		return matriculeClient;
	}

	public void setMatriculeClient(String matriculeClient) {
		this.matriculeClient = matriculeClient;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public String getAgenceCreation() {
		return agenceCreation;
	}

	public void setAgenceCreation(String agenceCreation) {
		this.agenceCreation = agenceCreation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Compte() {

	}

	public Compte(String numeroCompte, String matriculeClient, String dateCreation, String dateExpiration, String solde,
			String agenceCreation, String description) {
		super();
		this.numeroCompte = numeroCompte;
		this.matriculeClient = matriculeClient;
		this.dateCreation = dateCreation;
		this.dateExpiration = dateExpiration;
		this.solde = solde;
		this.agenceCreation = agenceCreation;
		this.description = description;
	}

}
