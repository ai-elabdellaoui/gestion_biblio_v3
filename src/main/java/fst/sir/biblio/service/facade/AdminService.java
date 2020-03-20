package fst.sir.biblio.service.facade;

import java.util.Date;

import fst.sir.biblio.bean.Admin;


public interface AdminService {
	Admin findBydateContra(Date dateContra);

	int ajouterAdmin(Admin admin);

	int loginAdmin(String email, String password);

	Admin findByEmail(String email);

	int removeAdminByCin(String cin);

	int countNomberAdherents();

	int countNomberEmprunts();
	
	Admin findByCin(String cin);

}
