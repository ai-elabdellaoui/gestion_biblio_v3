package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.TypeAdherent;

@Repository
public interface TypeAdherentDao extends JpaRepository<TypeAdherent, Long> {
	List<Adherent> findByProfession(String profession);
	int deleteByProfession(String profession);

}
