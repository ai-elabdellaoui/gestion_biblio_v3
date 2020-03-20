/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Emprunt implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEmprunt;
    @OneToMany(mappedBy = "emprunt")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmpruntDetail> empruntDetails= new ArrayList();

    @ManyToOne
    private Adherent adherent;

    public Emprunt() {
    }

    public Emprunt(Long id, String ref) {
        this.id = id;
        this.ref = ref;
    }

    public Emprunt(Long id, String ref, Date dateEmprunt, Adherent adherent) {
        this.id = id;
        this.ref = ref;
        this.dateEmprunt = dateEmprunt;
        this.adherent = adherent;
    }
    

    public Emprunt(Long id, String ref, List<EmpruntDetail> empruntDetails, Adherent adherent) {
        this.id = id;
        this.ref = ref;
        this.empruntDetails = empruntDetails;
        this.adherent = adherent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public List<EmpruntDetail> getEmpruntDetails() {
        return empruntDetails;
    }

    public void setEmpruntDetails(List<EmpruntDetail> empruntDetails) {
        this.empruntDetails = empruntDetails;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.ref);
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
        final Emprunt other = (Emprunt) obj;
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", ref=" + ref + ", dateEmprunt=" + dateEmprunt + ", empruntDetails="
				+ empruntDetails + ", adherent=" + adherent + "]";
	}

    public void setDateRetourEffective(Date dateRestitutionEffective) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
