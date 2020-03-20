package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Fournisseur;

public interface FournisseurService {
	
	Fournisseur findByCin(String cin);
	int save(Fournisseur forniseur);
	
	int deleteByCin(String cin);
	 List<Fournisseur> findAll();

}
