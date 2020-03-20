package fst.sir.biblio.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.dao.AdminDao;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.AdminService;
import fst.sir.biblio.service.facade.EmpruntService;
import fst.sir.biblio.utils.Utils;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	private Utils utils = new Utils();

	@Override
	public Admin findBydateContra(Date dateContra) {
		if (utils.checkDate(dateContra) > 0) {
			return adminDao.findByDateContrat(dateContra);
		} else {
			return null;
		}

	}

	@Autowired
	private AdherentService adherentService;

	
	@Autowired
	private EmpruntService empruntService;

	@Override
	public int loginAdmin(String email, String password) {

		Admin isAdmin = findByEmail(email);
		if (email != isAdmin.getEmail() && password != isAdmin.getEmail()) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public int countNomberAdherents() {
		int nomberdseAdherent = 0;
		List<Adherent> listAdherent = new ArrayList<Adherent>();
		listAdherent = adherentService.findAll();
		for (Adherent adherent : listAdherent) {
			nomberdseAdherent++;

		}
		return nomberdseAdherent;

	}

	@Override
	public int countNomberEmprunts() {
		int nomberdseEmprunts = 0;
		List<Emprunt> listEmprunts = new ArrayList<Emprunt>();
		listEmprunts = empruntService.findAll();
		for (Emprunt emprunt : listEmprunts) {
			nomberdseEmprunts++;
		}
		return nomberdseEmprunts;

	}

	@Override
	public int ajouterAdmin(Admin admin) {
		Admin isAdmin = findByEmail(admin.getEmail());
		if (Strings.isBlank(admin.getCin()) && !Strings.isNotEmpty(admin.getCin()) && 
				Strings.isBlank(admin.getEmail()) && !Strings.isNotEmpty(admin.getEmail()) &&
				Strings.isBlank(admin.getpassword()) && !Strings.isNotEmpty(admin.getpassword())) {
			return -2;
		}
			if (isAdmin != null) {
				return -1;
			}
		adminDao.save(admin);
		return 1;
	}

	@Override
	public Admin findByEmail(String email) {
		
		return adminDao.findByEmail(email);
	}

	@Override
	public int removeAdminByCin(String cin) {
		Admin adminFounded = findByCin(cin);
		if(adminFounded==null) return -1;
		else {
			adminDao.delete(adminFounded);
			return 1;
		}
	}

	@Override
	public Admin findByCin(String cin) {
		
		return adminDao.findByCin(cin);
	}
}
