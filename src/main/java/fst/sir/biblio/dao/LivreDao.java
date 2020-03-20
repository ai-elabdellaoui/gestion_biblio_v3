package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fst.sir.biblio.bean.Livre;
import org.springframework.stereotype.Repository;
@Repository
public interface LivreDao extends JpaRepository<Livre,Long > {
	public void deleteByIsbn(String isbn);
	
	public List<Livre> findByTitre(String titre);
	public List<Livre> findByAuteur (String auteur);
        public Livre findByIsbn(String isbn);
	
	@Query("select disponible from Livre")
	public int disponible(String titre);

}
