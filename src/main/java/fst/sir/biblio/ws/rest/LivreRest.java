/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.service.facade.LivreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/biblio/livre")
public class LivreRest {

    @Autowired
    private LivreService livreService;

    @PostMapping("/")
    public int save(@RequestBody Livre livre) {
        return livreService.save(livre);
    }

    @DeleteMapping("/isbn/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return livreService.deleteByIsbn(isbn);
    }

    @GetMapping("/isbn/{isbn}")
    public Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }

    @GetMapping("/titre/{titre}")
    public List<Livre> findByTitre(@PathVariable String titre) {
        return livreService.findByTitre(titre);
    }

    @GetMapping("/auteur/{auteur}")
    public List<Livre> findByAuteur(@PathVariable String auteur) {
        return livreService.findByAuteur(auteur);
    }

    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }

    @GetMapping("/disponible/titre/{titre}")
    public int disponible(@PathVariable String titre) {
        return livreService.disponible(titre);
    }

}
