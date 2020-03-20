package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Agent;
import fst.sir.biblio.dao.AgentDao;
import fst.sir.biblio.service.facade.AgentService;
@Service
public class AgentServiceImpl implements AgentService{
	@Autowired
	AgentDao agentDao;

	@Override
	public List<Agent> findByNom(String nom) {
		
		return agentDao.findByNom(nom) ;
	}
	

	@Override
	public Agent findByCne(String cne) {
		// TODO Auto-generated method stub
		return agentDao.findByCne(cne);
	}

	@Override
	public int save(Agent agent) {	
		Agent founded =findByCne(agent.getCne());
		if (founded==null) {
			return 0;
			
		}else {
			agentDao.save(agent);
			return 1;
			
		}
	}


}
