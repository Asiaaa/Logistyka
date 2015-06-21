/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logistyka;

import Model.Magazyn;
import Model.MagazynJdbcDAO;
import Model.Uzytkownik;
import Model.UzytkownikJdbcDAO;
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
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
       // testing area :D
        
        MagazynJdbcDAO mag = new MagazynJdbcDAO();
        List<Magazyn> magazyny = new ArrayList<Magazyn>();
        
        magazyny=mag.PobierzMagazyny();
        if(magazyny==null)
        {
          System.out.println("Lista pusta :(");
        }
        else
        {
          for(Magazyn u: magazyny)
        {
          //System.out.println("Nazwa: "+u.getNazwa());
        }
        }
        
        Magazyn magazyn = new Magazyn();
        magazyn=mag.PobierzMagazyn(2);
        //System.out.println("Nazwa: "+magazyn.getNazwa());
        
        Magazyn dodany = new Magazyn();
        dodany.setNazwa("M03");
        dodany.setUlicaMiejscowosc("Krakowska");
        dodany.setNrDomu(13);
        dodany.setNrLokalu(6);
        dodany.setKodPocztowy("31-525");
        dodany.setPoczta("Kraków");
        
        //mag.DodajMagazyn(dodany);
        
        //mag.UsunMagazyn(3);
        
        
    }
    
}
