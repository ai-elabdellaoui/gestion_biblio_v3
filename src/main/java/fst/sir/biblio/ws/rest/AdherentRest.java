package fst.sir.biblio.ws.rest;

import java.util.Date;
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

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.TypeAdherentService;


@RestController
@RequestMapping("/biblio/adherent/")
public class AdherentRest {
	@Autowired
	private AdherentService adherentservice;
	@Autowired
	private TypeAdherentService typeAdherentService;
	

	@GetMapping("/")
	public List<Adherent> findAll() {
		return adherentservice.findAll();
	}
	

	@PostMapping("/")
	public void save(@RequestBody Adherent adherent) {
		adherentservice.save(adherent);
	}

	@GetMapping("/cin/{cin}")
	public Adherent findByCin(@PathVariable String cin) {
		return adherentservice.findByCin(cin);
	}

	@GetMapping("/dateInscription/{dateInscription}")
	public List<Adherent> findByDateInscription(@PathVariable Date dateInscription) {

		return adherentservice.findByDateInscription(dateInscription);
	}

	@GetMapping("/email/{email}")
	public Adherent findByEmail(@PathVariable String email) {

		return adherentservice.findByEmail(email);
	}

	@PutMapping("/modify/cin/{cin}")
	public int modifyByCin(@PathVariable String cin) {
		return adherentservice.modifyByCin(cin);
	}

	@DeleteMapping("/remove/cin/{cin}")
	public int removeByCin(@PathVariable String cin) {
		return adherentservice.removeByCin(cin);
	}
     @GetMapping("/typeadherent/profession/{profession}")
	public List<Adherent> findByProfession(String profession) {
		return typeAdherentService.findByProfession(profession);
	}

//    @GetMapping("/email/{email}/password/{password}")
//	public Adherent findByLogin(@PathVariable String email,@PathVariable String password) {
//		return adherentservice.findByLogin(email, password);
//	}
    
    
    
	

}
