/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HP
 */
@Entity
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qteAchete;
    private int qteDisponible;
    private int qteLoue;

    @ManyToOne
    private Bibliotheque bibliotheque;
    
    @ManyToOne
    private Livre livre;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQteAchete() {
        return qteAchete;
    }

    public void setQteAchete(int qteAchete) {
        this.qteAchete = qteAchete;
    }

    public int getQteDisponible() {
        return qteDisponible;
    }

    public void setQteDisponible(int qteDisponible) {
        this.qteDisponible = qteDisponible;
    }

    public int getQteLoue() {
        return qteLoue;
    }

    public void setQteLoue(int qteLoue) {
        this.qteLoue = qteLoue;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", qteAchete=" + qteAchete + ", qteDisponible=" + qteDisponible + ", qteLoue=" + qteLoue + ", bibliotheque=" + bibliotheque + '}';
    }

}
