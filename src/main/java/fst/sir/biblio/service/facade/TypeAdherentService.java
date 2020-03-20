package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.TypeAdherent;

public interface TypeAdherentService {
	List<Adherent> findByProfession(String profession);
	int save(TypeAdherent typeAdherent);
	int deleteByProfession(String profession);
	

}
