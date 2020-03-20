/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.service.facade.EmpruntService;
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
@RequestMapping("/biblio/emprunt")
@RestController
public class EmpruntRest {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping("/ref/{ref}")
    public Emprunt findByRef(@PathVariable String ref) {
        return empruntService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return empruntService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Emprunt> findAll() {
        return empruntService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Emprunt emprunt) {
        return empruntService.save(emprunt, emprunt.getEmpruntDetails());
    }

    @GetMapping("/cin/{cin}")
    public List<Emprunt> findByAdherentCin(@PathVariable String cin) {
        return empruntService.findByAdherentCin(cin);
    }

}
