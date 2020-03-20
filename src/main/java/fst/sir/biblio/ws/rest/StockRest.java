/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.ws.rest;

import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.service.facade.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/biblio/stock")
public class StockRest {
    @Autowired
    private StockService  stockService;
@GetMapping("/bibliotheque/ref/{ref}")
    public Stock findByBibliothequeRef(@PathVariable String ref) {
        return stockService.findByBibliothequeRef(ref);
    }
@GetMapping("/bibliotheque/nom/{nom}")
    public Stock findByBibliothequeNom(@PathVariable String nom) {
        return stockService.findByBibliothequeNom(nom);
    }
@GetMapping("/")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
@PutMapping("/")
    public int save(@RequestBody Stock stock) {
        return stockService.save(stock);
    }
@GetMapping("/qteDisponible/{stock}")
    public int qteDisponible(@RequestBody Stock stock) {
        return stockService.qteDisponible(stock);
    }
    
    
}
