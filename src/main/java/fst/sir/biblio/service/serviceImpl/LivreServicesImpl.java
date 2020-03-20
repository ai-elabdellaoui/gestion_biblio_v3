package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.service.facade.LivreService;
import fst.sir.biblio.dao.LivreDao;
import org.springframework.stereotype.Service;
@Service
public class LivreServicesImpl implements LivreService {

    @Autowired
    private LivreDao livreDao;

    @Override
    public List<Livre> findByTitre(String titre) {

        return livreDao.findByTitre(titre);
    }

    @Override
    public List<Livre> findByAuteur(String auteur) {

        return livreDao.findByAuteur(auteur);
    }

    @Override
    public int disponible(String titre) {

        if (livreDao.disponible(titre) > 0) {
            return 1;
        }
        return 0;

    }

    @Override
    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }

    @Override
    public int save(Livre livre) {
        Livre livreExist = findByIsbn(livre.getIsbn());
        if (livreExist != null) {
            return -1;
        } else {
            livreDao.save(livre);
            return 1;
        }
    }

    

    @Override
    public List<Livre> findAll() {
        return livreDao.findAll();
    }

    @Override
    public int deleteByIsbn(String isbn) {
        livreDao.deleteByIsbn(isbn);
        return 1;
    }

}
