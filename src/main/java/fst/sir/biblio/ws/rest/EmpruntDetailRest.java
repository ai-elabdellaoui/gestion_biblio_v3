/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import fst.sir.biblio.service.facade.EmpruntDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/biblio/empruntDetail")

public class EmpruntDetailRest {

    @Autowired
    private EmpruntDetailService empruntDetailService;

    @GetMapping("/emprunt/reference/{reference}")
    public List<EmpruntDetail> findByEmpruntRef(@PathVariable String ref) {
        return empruntDetailService.findByEmpruntRef(ref);
    }
    @DeleteMapping("/emprunt/reference/{reference}")
    public int deleteByEmpruntRef(@PathVariable String ref) {
        return empruntDetailService.deleteByEmpruntRef(ref);
    }

    @PostMapping("/")
    public int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        return empruntDetailService.save(emprunt, empruntDetails);
    }

    @GetMapping("/validate")
    public boolean validateEmpruntDetail(Emprunt emprunt,List<EmpruntDetail> empruntDetails) {
        return empruntDetailService.validateEmpruntDetail(emprunt, empruntDetails);
    }

    
    
}
