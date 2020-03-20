/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.service.facade.AchatDetailService;

@RestController
@RequestMapping("/biblio/achatdetail")
public class AchatDetailRest {
	@Autowired
	private AchatDetailService achatDetailService;
@PutMapping("/achat/{achat}/achatDetails/{achatDetails}")
    public boolean validateAchatDetail(@RequestBody Achat achat, List<AchatDetail> achatDetails) {
        return achatDetailService.validateAchatDetail(achat, achatDetails);
    }
@PostMapping("/")
    public int save(@RequestBody Achat achat, List<AchatDetail> achatDetails) {
        return achatDetailService.save(achat, achatDetails);
    }
@GetMapping("/ref/{ref}")
    public List<AchatDetail> findByAchatRef(@PathVariable String ref) {
        return achatDetailService.findByAchatRef(ref);
    }
@DeleteMapping("/ref/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return achatDetailService.deleteByAchatRef(ref);
    }

    public void updateStock() {
        achatDetailService.updateStock();
    }

}
