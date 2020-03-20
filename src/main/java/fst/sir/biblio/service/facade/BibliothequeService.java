/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Bibliotheque;
import java.util.List;

/**
 *
 * @author HP
 */

public interface BibliothequeService {
    Bibliotheque findByRef(String ref);
    Bibliotheque findByNom(String nom);
    List<Bibliotheque> findAll();
    int save(Bibliotheque bibliotheque);
}
