package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Agent;

public interface AgentService {
    List<Agent> findByNom(String nom);
    int save(Agent agent);
    Agent findByCne(String cne);

}
