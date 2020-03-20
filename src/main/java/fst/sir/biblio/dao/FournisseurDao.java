package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fst.sir.biblio.bean.Fournisseur;
import org.springframework.stereotype.Repository;
@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur,Long>{
	
	Fournisseur findByCin(String cin);
	void deleteByCin(String cin);
	
	
	
	

}
