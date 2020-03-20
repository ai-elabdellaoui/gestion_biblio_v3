/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.dao.AchatDetailDao;
import fst.sir.biblio.service.facade.AchatDetailService;
import fst.sir.biblio.service.facade.FournisseurService;

@Service
public class AchatDetailServiceImpl implements AchatDetailService {
	@Autowired
	private AchatDetailDao achatDetailDao;
        
        @Autowired
	private FournisseurService fournisseurService;
        
	private AchatDetail achatDetail = new AchatDetail();
	
        
        
        private Stock stock = new Stock();
	


	@Override
	public boolean validateAchatDetail(Achat achat, List<AchatDetail> achatDetails) {
		List<AchatDetail> validefournisseuer = achatDetails.stream().filter(ad->fournisseurService.findByCin(ad.getFournisseur().getCin())!=null).collect(Collectors.toList());
		return validefournisseuer.size() == achatDetails.size();
	}

	@Override
	public int save(Achat achat, List<AchatDetail> achatDetails) {
		if(validateAchatDetail( achat, achatDetails)) {
	
	for (AchatDetail achatDetail : achatDetails) {
		achatDetail .setAchat(achat);
                updateStock();
		achatDetailDao.save(achatDetail );
	}
	}
	return 1;}
	
    @Transactional
	@Override
	public int deleteByAchatRef(String ref) {
    	List<AchatDetail> achatDetailFounded=findByAchatRef(ref);
    	for (AchatDetail achatDetail : achatDetailFounded) {
    		
    		achatDetailDao.delete(achatDetail );
		}
		return 1;
	
	}

	@Override
	public List<AchatDetail> findByAchatRef(String ref) {
		
		return achatDetailDao.findByAchatRef(ref);
	}

    @Override
    public void updateStock() {
        int qte = stock.getQteAchete() ;
      stock.setQteAchete((int) achatDetail.getQte()+qte);
    }


}
