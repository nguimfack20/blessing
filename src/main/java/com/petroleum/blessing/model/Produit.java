package com.petroleum.blessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {

	 public Produit() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Produit( String codeProduit, String libelle, String tarifAchat, String tarifVente) {
		super();
		this.codeProduit = codeProduit;
		this.libelle = libelle;
		this.tarifAchat = tarifAchat;
		this.tarifVente = tarifVente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "code_produit")
	private String codeProduit;
	
	@Column(name = "libelle")
	private String libelle;
	
	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getTarifAchat() {
		return tarifAchat;
	}

	public void setTarifAchat(String tarifAchat) {
		this.tarifAchat = tarifAchat;
	}

	public String getTarifVente() {
		return tarifVente;
	}

	public void setTarifVente(String tarifVente) {
		this.tarifVente = tarifVente;
	}

	@Column(name = "tarif_achat")
	private String tarifAchat;
	
	@Column(name = "tarif_vente")
	private String tarifVente;
	
	
}
