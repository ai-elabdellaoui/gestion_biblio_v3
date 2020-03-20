package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Reservation;

public interface ReservationService {
	
	public List<Reservation> afficherReservations(String codeReservation);
	public int ajouterReservation(Reservation reseRvation);
	public boolean deleteByCodeReservation(String codeReservation);
	public Reservation findByCodereservation(String codeReservation);
	

}

