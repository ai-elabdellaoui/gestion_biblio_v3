package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Agent;
@Repository
public interface AgentDao extends JpaRepository<Agent,Long> {
	
      List<Agent> findByNom(String nom);
     
	Agent findByCne(String cne);
 
}
