package fst.sir.biblio.ws.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.service.facade.AdminService;


@RestController
@RequestMapping("/biblio/admin")
public class AdminRest {
	@Autowired
	AdminService adminService;
    
	@GetMapping("/dateContra/{dateContra}")
	public Admin findBydateContra(@PathVariable  @DateTimeFormat(pattern = "dd/mm/yyyy")Date dateContra) {
		return adminService.findBydateContra(dateContra);
	}
    @PostMapping("/")
	public int ajouterAdmin( @RequestBody Admin admin) {
		return adminService.ajouterAdmin(admin);
	}
    @PostMapping("/email/{email}/password/{password}")
	public int loginAdmin(@PathVariable String email,@PathVariable String password) {
		return adminService.loginAdmin(email, password);
	}
    @GetMapping("/email/{email}")
    public Admin findByEmail(@PathVariable String email) {
		return adminService.findByEmail(email);
	}
    @DeleteMapping("/delete/cin/{cin}")
	public int removeAdminByCin(@PathVariable String cin) {
		return adminService.removeAdminByCin(cin);
	}
    @GetMapping("/countAderent/")
	public int countNomberAdherents() {
		return adminService.countNomberAdherents();
	}
    @GetMapping("/countEmprunt/")
	public int countNomberEmprunts() {
		return adminService.countNomberEmprunts();
	}
	
	
	
	

}
