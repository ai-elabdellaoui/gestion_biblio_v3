/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import fst.sir.biblio.bean.Bibliotheque;
import fst.sir.biblio.service.facade.BibliothequeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/biblio/bibliotheque")
public class BibliothequeRest {
    @Autowired
    private BibliothequeService bibliothequeService;
@GetMapping("/ref/{ref}")
    public Bibliotheque findByRef(@PathVariable String ref) {
        return bibliothequeService.findByRef(ref);
    }
@GetMapping("/nom/{nom}")
    public Bibliotheque findByNom(@PathVariable String nom) {
        return bibliothequeService.findByNom(nom);
    }
@GetMapping("/")
    public List<Bibliotheque> findAll() {
        return bibliothequeService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Bibliotheque bibliotheque) {
        return bibliothequeService.save(bibliotheque);
    }
    
    
    
}
