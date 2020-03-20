package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fst.sir.biblio.bean.Reservation;
import fst.sir.biblio.dao.ReservationDao;
import fst.sir.biblio.service.facade.ReservationService;
import org.springframework.stereotype.Service;
@Service
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
private	ReservationDao reservationDao;

	@Override
	public List<Reservation> afficherReservations(String codereservation) {
		
		return reservationDao.findAll();
	}

	@Override
	public int ajouterReservation(Reservation reservation) {
		Reservation reservationExiste =
				reservationDao.findByCodeReservation(reservation.getCodeReservation());
		if(reservationExiste==null) {return -1;}
		reservationDao.save(reservation);
		return 1;
		
		
	}


	@Override
	public Reservation findByCodereservation(String codeReservation) {
		
		return reservationDao.findByCodeReservation(codeReservation);
	}

	

    @Override
    public boolean deleteByCodeReservation(String codeReservation) {
        if(reservationDao.findByCodeReservation(codeReservation)==null) {return false;}
		reservationDao.deleteByCodeReservation(codeReservation);
		return true;
    }
	
	




	
	
	
	
	
	
	
}
