package fst.sir.biblio.service.facade;

import java.util.Date;
import java.util.List;

import fst.sir.biblio.bean.Adherent;
import org.springframework.data.repository.query.Param;

public interface AdherentService {
	List<Adherent> findAll();

	int save(Adherent adherent);

	Adherent findByCin(String cin);

	List<Adherent> findByDateInscription(Date dateInscription);

	Adherent findByEmail(String email);

	int modifyByCin(String cin);

	int removeByCin(String cin);

	Adherent findByLoginAndPassword(String email, String password);

//	List<Adherent> findByMotCle(@Param(value = "motcle") String motcle);

	

}
