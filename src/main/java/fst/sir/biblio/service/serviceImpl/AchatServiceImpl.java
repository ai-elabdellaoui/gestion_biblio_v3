package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.dao.AchatDao;
import fst.sir.biblio.service.facade.AchatDetailService;
import fst.sir.biblio.service.facade.AchatService;
import fst.sir.biblio.service.facade.FournisseurService;
@Service
public class AchatServiceImpl  implements AchatService{
@Autowired
private AchatDao achatDao;
@Autowired
private FournisseurService fournisseurService;
@Autowired
private AchatDetailService achatDetailService;

	@Override
	public List<Achat> findAll() {
		return achatDao.findAll();
	}

	@Override
	public int save(Achat achat,List<AchatDetail> achatDetails) {
		
		Achat achatFonded=findByRef(achat.getRef());
		Fournisseur fournesseurFounded=fournisseurService.findByCin(achat.getFournisseur().getCin());
		if(fournesseurFounded==null && achatFonded==null) {
			return -1;
		
		}else if(!achatDetailService.validateAchatDetail(achat,achatDetails)) 
		{
			return -2;
			 
		}else {
			achat.setFournisseur(fournesseurFounded);
			achatDao.save(achat);
			
			
		}
		return 1;
	}


	@Override
	public int deleteByRef(String ref) {
		Achat remove=findByRef(ref);
		List<AchatDetail> achatDetails=achatDetailService.findByAchatRef(ref);
		for (AchatDetail achatDetail : achatDetails) {
			achatDetailService.deleteByAchatRef(ref);
			
		}
		achatDao.delete(remove);
	return 1;
	
	}

	@Override
	public Achat findByRef(String ref) {
		return achatDao.findByRef(ref);
	}


}
