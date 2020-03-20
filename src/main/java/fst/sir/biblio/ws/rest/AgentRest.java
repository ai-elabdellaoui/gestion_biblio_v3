package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fst.sir.biblio.bean.Agent;
import fst.sir.biblio.service.facade.AgentService;
@RestController
@RequestMapping("/biblio/agent")
public class AgentRest {
	
	@Autowired
	AgentService agentService;
     @GetMapping("/nom/{nom}")
	public List<Agent> findByNom(String nom) {
		return agentService.findByNom(nom);
	}
    @PostMapping("/")
	public int save(@RequestBody Agent agent) {
		return agentService.save(agent);
	}
    @GetMapping("/nom/{cne}")
	public Agent findByCne(String cne) {
		return agentService.findByCne(cne);
	}

	
	
}
