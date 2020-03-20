package fst.sir.biblio.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.dao.AdherentDao;
import fst.sir.biblio.dao.TypeAdherentDao;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.EmpruntService;
import fst.sir.biblio.utils.Utils;

@Service
public class AdherentServiceImpl implements AdherentService {

    /**
     *
     */
    @Autowired
    private AdherentDao adherentDao;
    private Utils util;
    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private TypeAdherentDao taypeAdherentDao;

    @Override
    public List<Adherent> findAll() {

        return adherentDao.findAll();
    }

    @Override
    public int save(Adherent adherent) {

        Adherent adherentFounded = findByCin(adherent.getCin());

        if (adherentFounded != null) {
            return -1;
        } else {
            adherentDao.save(adherent);
            return 1;
        }

    }

    @Override
    public Adherent findByCin(String cin) {

        return adherentDao.findByCin(cin);
    }

    @Override
    public List<Adherent> findByDateInscription(Date dateInscription) {
        if (util.checkDate(dateInscription) < 0) {

            return adherentDao.findByDateInscription(dateInscription);
        } else {
            return null;
        }
    }

    @Override
    public Adherent findByEmail(String email) {
        return adherentDao.findByEmail(email);
    }

    @Override
    public int modifyByCin(String cin) {
        Adherent adherent = findByCin(cin);
        if (adherent == null) {
            return -1;
        } else {
            adherentDao.save(adherent);
            return 1;
        }
    }

    @Transactional
    @Override
    public int removeByCin(String cin) {
        Adherent adherent = findByCin(cin);
        List<Emprunt> empruntes = empruntService.findByAdherentCin(adherent.getCin());
        if (adherent == null && empruntes == null) {
            return -1;
        } else {
            for (Emprunt emprunt : empruntes) {
                empruntService.deleteByRef(emprunt.getRef());
            }
            adherentDao.delete(adherent);

            return 1;
        }
    }

    public List<Adherent> findByProfession(String profession) {

        return taypeAdherentDao.findByProfession(profession);
    }

    @Override
    public Adherent findByLoginAndPassword(String email, String password) {
        if (email != " " && password != "") {
            return adherentDao.findByLoginAndPassword(email, password);

        } else {
            return null;
        }

    }


//    @Override
//    public List<Adherent> findByMotCle(String motcle) {
//       return adherentDao.findByMotCle(motcle);
//    }

}
