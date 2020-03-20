package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.dao.FournisseurDao;
import fst.sir.biblio.service.facade.FournisseurService;
@Service
public class FournisseurSerImp implements FournisseurService {
	@Autowired
	private FournisseurDao fournisseurDao;

	@Override
	public Fournisseur findByCin(String cin) {
		return fournisseurDao.findByCin(cin);
	}

	@Override
	public int save(Fournisseur forniseur) {
		Fournisseur fournisseurFounded= findByCin(forniseur.getCin());
		if(fournisseurFounded!=null) {
			return -1;
		}else {
			fournisseurDao.save(forniseur);
			return 1;
		}
		
	}
    @Transactional
	@Override
	public int deleteByCin(String cin) {
    	Fournisseur  fournisseurFounded= findByCin(cin);
    	
    	if(fournisseurFounded==null) {
			return -1;
		}else {
			fournisseurDao.deleteByCin(fournisseurFounded.getCin());
			return 1;
		}
		
	}

	@Override
	public List<Fournisseur> findAll() {
	
		return fournisseurDao.findAll();
	}
	
	}
