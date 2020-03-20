package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;

public interface AchatService {

	Achat findByRef(String ref);

	List<Achat> findAll();

	int deleteByRef(String ref);

	int save(Achat achat, List<AchatDetail> achatDetails);

}
