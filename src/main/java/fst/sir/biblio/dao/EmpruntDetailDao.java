/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.dao;

import fst.sir.biblio.bean.EmpruntDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface EmpruntDetailDao extends JpaRepository<EmpruntDetail, Long>{
    public List<EmpruntDetail> findByEmpruntRef(String ref);
    public int deleteByEmpruntRef(String ref);
}
