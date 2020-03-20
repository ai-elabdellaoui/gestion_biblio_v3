package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.service.facade.AchatService;

@RequestMapping("/biblio/achat")
@RestController
public class AchatRest {
@Autowired
AchatService achatService ;

@GetMapping("/ref/{ref}")
public Achat findByRef(@PathVariable String ref) {
	return achatService.findByRef(ref);
}
@GetMapping("/")
public List<Achat> findAll() {
	return achatService.findAll();
}
@DeleteMapping("/ref/{ref}")
public int deleteByRef(String ref) {
	return achatService.deleteByRef(ref);
}
@PostMapping("/")
public int save(@RequestBody Achat achat, @RequestBody List<AchatDetail> achatDetails) {
	return achatService.save(achat, achatDetails);
}

}

