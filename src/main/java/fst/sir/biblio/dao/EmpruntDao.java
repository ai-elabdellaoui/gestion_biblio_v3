/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.dao;

import fst.sir.biblio.bean.Emprunt;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Long>{
    Emprunt findByRef(String ref);
    int deleteByRef(String reference);
    List<Emprunt> findByAdherentCin(String cin);
    
}