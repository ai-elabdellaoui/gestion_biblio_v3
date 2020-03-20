package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;

@Repository
public interface AchatDetailDao extends JpaRepository<AchatDetail, Long>{
	 List<AchatDetail>  findByAchatRef(String ref);
	  int deleteByAchatRef(String ref);


}
