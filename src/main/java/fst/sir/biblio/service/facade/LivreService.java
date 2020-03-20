package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Livre;

public interface LivreService {
	
	public int save(Livre livre);
	public int deleteByIsbn(String isbn);
	public Livre findByIsbn(String isbn);
	public List<Livre> findByTitre(String titre);
	public List<Livre> findByAuteur (String auteur);
        public List<Livre> findAll();
	public int disponible(String titre);
	
	
}
