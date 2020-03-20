package fst.sir.biblio.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
   private Long id;
	private String nom ;
	private String email;
	private String telephone;
	private String cne;

	@ManyToOne
	private Bibliotheque bibliotheque;
	public Agent() {
		super();
	}

	public Agent(String nom, String email, String telephone, String cne, Bibliotheque bibliotheque) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.cne = cne;
		
		this.bibliotheque = bibliotheque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBiblioteque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

    
	
	
	
	
	
	

}
