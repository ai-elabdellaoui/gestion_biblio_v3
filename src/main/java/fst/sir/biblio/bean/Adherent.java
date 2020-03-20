
package fst.sir.biblio.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author 
 */
@Entity
@Table(name = "adherent")
public class Adherent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateInscription;
	private String nomPhoto;
	private String tel;
	private String password;
	private String login;
	@ManyToOne
	private TypeAdherent typeAdherent;

	public Adherent() {
	}

	public Adherent(Long id, String cin, String nom, String prenom, String email, Date dateInscription, String nomPhoto,
			String tel, TypeAdherent typeAdherent) {
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateInscription = dateInscription;
		this.nomPhoto = nomPhoto;
		this.tel = tel;
		this.typeAdherent = typeAdherent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public TypeAdherent getTypeAdherent() {
		return typeAdherent;
	}

	public void setTypeAdherent(TypeAdherent typeAdherent) {
		this.typeAdherent = typeAdherent;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Objects.hashCode(this.id);
		hash = 37 * hash + Objects.hashCode(this.cin);
		hash = 37 * hash + Objects.hashCode(this.nom);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Adherent other = (Adherent) obj;
		if (!Objects.equals(this.cin, other.cin)) {
			return false;
		}
		if (!Objects.equals(this.nom, other.nom)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Adherent{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", dateInscription=" + dateInscription + ", nomPhoto=" + nomPhoto + ", tel=" + tel + ", typeAdherent="
				+ typeAdherent + '}';
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

}
