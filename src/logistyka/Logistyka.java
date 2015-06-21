/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logistyka;

import Controller.*;
import Model.Magazyn;
import Model.MagazynJdbcDAO;
import Model.Produkt;
import Model.Uzytkownik;
import Model.UzytkownikJdbcDAO;
import View.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joanna
 */
public class Logistyka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Start theStart = new Start();
        Nav theNav = new Nav();
        LoginController theLoginController = new LoginController(theStart, theNav);      
    }
    
    
}
