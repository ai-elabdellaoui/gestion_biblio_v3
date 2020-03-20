/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author HP
 */
@Entity
public class Livre implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private int nbrJourEmprunt;
    private String titre;
    private String auteur;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEdition;

    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Theme theme;

    private String resume;
    private String nomPhoto;
    private long nbrPage;
    private String tome;
    private int disponible;

    public int getNbrJourEmprunt() {
        return nbrJourEmprunt;
    }

    public void setNbrJourEmprunt(int nbrJourEmprunt) {
        this.nbrJourEmprunt = nbrJourEmprunt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }

    public long getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(long nbrPage) {
        this.nbrPage = nbrPage;
    }

    public String getTome() {
        return tome;
    }

    public void setTome(String tome) {
        this.tome = tome;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
        result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
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
        Livre other = (Livre) obj;
        if (auteur == null) {
            if (other.auteur != null) {
                return false;
            }
        } else if (!auteur.equals(other.auteur)) {
            return false;
        }
        if (categorie == null) {
            if (other.categorie != null) {
                return false;
            }
        } else if (!categorie.equals(other.categorie)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (isbn == null) {
            if (other.isbn != null) {
                return false;
            }
        } else if (!isbn.equals(other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livre [id=" + id + ", isbn=" + isbn + ", titre=" + titre + ", auteur=" + auteur + ", dateEdition="
                + dateEdition + ", categorie=" + categorie + ", theme=" + theme + ", resume=" + resume + ", nomPhoto="
                + nomPhoto + ", nbrPage=" + nbrPage + ", tome=" + tome + ", disponible=" + disponible + "]";
    }

}
