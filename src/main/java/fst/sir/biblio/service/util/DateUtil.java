/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.util;

import java.util.Date;

/**
 *
 * @author HP
 */
public class DateUtil {
    public static Date addDays(Date dateEmprunt, int nombreJourEmprunt) {
        long milliSecoindeSum = dateEmprunt.getTime() + nombreJourEmprunt * 24 * 3600 * 1000;
        return new Date(milliSecoindeSum);
    }
}
