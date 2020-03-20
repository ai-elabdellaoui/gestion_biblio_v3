/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import fst.sir.biblio.dao.EmpruntDao;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.EmpruntDetailService;
import fst.sir.biblio.service.facade.EmpruntService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    private EmpruntDao empruntDao;

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private EmpruntDetailService empruntDetailService;
    private EmpruntDetail empruntDetail = new EmpruntDetail();

    @Override
    public Emprunt findByRef(String ref) {
        return empruntDao.findByRef(ref);

    }

    /**
     *
     * @param ref
     * @return
     */
    @Transactional
    @Override
    public int deleteByRef(String ref) {
        int resDetail = empruntDetailService.deleteByEmpruntRef(ref);
        int resEmprunt = empruntDao.deleteByRef(ref);
        return resDetail * resEmprunt;
    }

    @Override
    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    @Override
    public int restituer(String ref, Date dateRestitutionEffective) {
        Emprunt emprunt = findByRef(ref);
        if (emprunt == null) {
            return -1;
        } else if (empruntDetail.getDateRetourEffective() != null) {
            return -2;
        } else {
            empruntDetail.setDateRetourEffective(dateRestitutionEffective);
            empruntDao.save(emprunt);
            return 1;
        }
    }

    @Override
    public int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        Emprunt foundedEmprunt = findByRef(emprunt.getRef());
        Adherent adherent = adherentService.findByCin(emprunt.getAdherent().getCin());
        if (foundedEmprunt != null) {
            return -1;
        } else if (adherent == null) {
            return -2;

        } else if (!empruntDetailService.validateEmpruntDetail(emprunt, empruntDetails)) {
            return -3;
        } else {
            emprunt.setAdherent(adherent);
            emprunt.setDateEmprunt(new Date());
            empruntDao.save(emprunt);
            empruntDetailService.save(emprunt, empruntDetails);
            return 1;
        }
    }

    @Override
    public List<Emprunt> findByAdherentCin(String cin) {
        return empruntDao.findByAdherentCin(cin);
    }
}
