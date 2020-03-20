/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmpruntDetailService {
    public int save(Emprunt emprunt,List<EmpruntDetail>empruntDetails);
    public boolean validateEmpruntDetail(Emprunt emprunt,List<EmpruntDetail>empruntDetails);
    public List<EmpruntDetail> findByEmpruntRef(String ref);
    public int deleteByEmpruntRef(String ref);
    
    
}
