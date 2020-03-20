package fst.sir.biblio.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Adherent;
import org.springframework.data.repository.query.Param;

@Repository
public interface AdherentDao extends JpaRepository<Adherent, Long> {

    Adherent findByCin(String cin);

    List<Adherent> findByDateInscription(Date dateInscription);

    Adherent findByEmail(String email);

    Adherent findByLoginAndPassword(String email, String password);

    int deleteByCin(String cin);

//    @Query("select a from adherent a where a.nom like :motcle")
//    List<Adherent> findByMotCle(@Param(value = "motcle") String motcle);

}
