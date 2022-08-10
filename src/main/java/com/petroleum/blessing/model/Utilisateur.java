package com.petroleum.blessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "matricule")
	private String matricule;
	
	@Column(name = "password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "telephone")
	private int telephone;
	
	@Column(name = "numero_cni")
	private String numeroCni;
	
	@Column(name = "date_naissance")
	private String dateNaissance;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "actif")
	private String actif;
	
	public String getActif() {
		return actif;
	}


	public void setActif(String actif) {
		this.actif = actif;
	}
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "zone_travail")
	private String zoneTravail;
	
	@Column(name = "email")
	private String email;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String matricule, String nom, int telephone, String numeroCni, String dateNaissance, String role,
			String adresse, String zoneTravail, String email) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.telephone = telephone;
		this.numeroCni = numeroCni;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.adresse = adresse;
		this.zoneTravail = zoneTravail;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getNumeroCni() {
		return numeroCni;
	}
	public void setNumeroCni(String numeroCni) {
		this.numeroCni = numeroCni;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getZoneTravail() {
		return zoneTravail;
	}
	public void setZoneTravail(String zoneTravail) {
		this.zoneTravail = zoneTravail;
	}
	
	

}
