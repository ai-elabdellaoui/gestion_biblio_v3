package fst.sir.biblio.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fst.sir.biblio.bean.Reservation;
import org.springframework.stereotype.Repository;
@Repository
public interface ReservationDao extends JpaRepository<Reservation,Long>{
	
	public Reservation findByCodeReservation(String codeReserString);
	public void deleteByCodeReservation(String codeReserString);
	List<Reservation> findByDateReservation(String codeReservation);
	
	
	
	

}
