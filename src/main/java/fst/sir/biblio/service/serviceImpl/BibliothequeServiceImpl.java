/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Bibliotheque;
import fst.sir.biblio.dao.BibliothequeDao;
import fst.sir.biblio.service.facade.BibliothequeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class BibliothequeServiceImpl implements BibliothequeService{
    @Autowired
    BibliothequeDao bibliothequeDao;
    @Override
    public Bibliotheque findByRef(String ref) {
        return bibliothequeDao.findByRef(ref);
    }

    @Override
    public Bibliotheque findByNom(String nom) {
        return bibliothequeDao.findByNom(nom);
    }

    @Override
    public List<Bibliotheque> findAll() {
        return bibliothequeDao.findAll();
    }

    @Override
    public int save(Bibliotheque bibliotheque) {
        Bibliotheque founded = bibliothequeDao.findByRef(bibliotheque.getRef());
        if (founded != null) {
            return -1;
        }else{
        bibliothequeDao.save(bibliotheque);
        return 1;
        }
    }
    
}
