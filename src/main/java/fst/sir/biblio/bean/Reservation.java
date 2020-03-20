package fst.sir.biblio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String codeReservation;
public String getCodeReservation() {
	return codeReservation;
}
public void setCodeReservation(String codeReservation) {
	this.codeReservation = codeReservation;
}
private Date dateDemandeReservation;
private Date annulerReservation;
private Date dateReservation;
private Date fineReservation;
public Date getFineReservation() {
	return fineReservation;
}
public void setFineReservation(Date fineReservation) {
	this.fineReservation = fineReservation;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@ManyToOne
private Livre livre;
public Reservation() {
	super();
}
public Reservation(String codeReservation, Date dateDemandeReservation, Date annulerReservation, Date dateReservation,
		Date fineReservation, Livre livre, Adherent adherent) {
	super();
	this.codeReservation = codeReservation;
	this.dateDemandeReservation = dateDemandeReservation;
	this.annulerReservation = annulerReservation;
	this.dateReservation = dateReservation;
	this.fineReservation = fineReservation;
	this.livre = livre;
	this.adherent = adherent;
}
private Adherent adherent;
public Adherent getAdherent() {
	
	return adherent;
}
public void setAdherent(Adherent adherent) {
	this.adherent = adherent;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDateDemandeReservation() {
	return dateDemandeReservation;
}
public void setDateDemandeReservation(Date dateDemandeReservation) {
	this.dateDemandeReservation = dateDemandeReservation;
}
public Date getAnnulerReservation() {
	return annulerReservation;
}
public void setAnnulerReservation(Date annulerReservation) {
	this.annulerReservation = annulerReservation;
}
public Date getDateReservation() {
	return dateReservation;
}
public void setDateReservation(Date dateReservation) {
	this.dateReservation = dateReservation;
}
public Livre getLivre() {
	return livre;
}
public void setLivre(Livre livre) {
	this.livre = livre;
}}

	