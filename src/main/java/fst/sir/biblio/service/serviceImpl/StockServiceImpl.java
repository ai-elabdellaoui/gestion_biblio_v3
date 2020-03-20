/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.dao.StockDao;
import fst.sir.biblio.service.facade.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockDao stockDao;

    @Override
    public Stock findByBibliothequeRef(String ref) {
        return stockDao.findByBibliothequeRef(ref);
    }

    @Override
    public int save(Stock stock) {
       
       stockDao.save(stock);
       return 1;
    }

    @Override
    public int qteDisponible(Stock stock) {
        Stock founded = stockDao.findByBibliothequeRef(stock.getBibliotheque().getRef());
        if (founded != null) {
             int dispo = founded.getQteAchete()-stock.getQteLoue();
             founded.setQteDisponible(dispo);
                return dispo;
        }else{
        return -1;
        }
       
    }

    @Override
    public Stock findByBibliothequeNom(String nom) {
        return stockDao.findByBibliothequeNom(nom);
    }

    @Override
    public List<Stock> findAll() {
        return stockDao.findAll();
    }

    
}
