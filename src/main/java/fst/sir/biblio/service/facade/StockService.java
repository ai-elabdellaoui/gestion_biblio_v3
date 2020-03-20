/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Stock;
import java.util.List;

/**
 *
 * @author HP
 */
public interface StockService {
     Stock findByBibliothequeRef(String ref);
    Stock findByBibliothequeNom(String nom);
    List<Stock> findAll();
    int save(Stock stock);
    int qteDisponible(Stock stock);
   
}
