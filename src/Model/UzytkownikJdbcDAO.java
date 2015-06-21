/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joanna
 */
public class UzytkownikJdbcDAO implements UzytkownikDAO{
    
    BaseConnection Base = BaseConnection.getConnection();
    
    /* implementacja metod interfejsu UzytkownikDAO */
    
    public List<Uzytkownik> PobierzUzytkownikow()
    {
        List<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();
        ResultSet result = null;
        try{
        result = Base.stmt.executeQuery("SELECT US.ID_UZYTKOWNIK AS ID_UZYTKOWNIK, US.IMIE AS IMIE, US.NAZWISKO AS NAZWISKO, "
                + "A.ID_ADRES AS ID_ADRES, A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, "
                + "US.LOGIN AS LOGIN, A.NR_LOKALU AS NR_LOKALU, A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA, "
                + "US.EMAIL AS EMAIL, US.TELEFON AS TELEFON, U.ID_UPRAWNIENIA AS ID_UPRAWNIENIA, U.UPRAWNIENIE AS UPRAWNIENIE "
                + "FROM UZYTKOWNIK US INNER JOIN ADRES A ON US.ID_ADRES=A.ID_ADRES "
                + "INNER JOIN UPRAWNIENIA U ON US.ID_UPRWNIENIA=U.ID_UPRAWNIENIA");
        
        /* DZIEKI ZA LITEROWKI W BAZIE -_- NIE POPRAWIAC ICH JUZ!!!!! */
        
        
        while(result.next()){
                    Uzytkownik uzytkownik = new Uzytkownik();
                    uzytkownik.setIdUzytkownik(result.getInt("ID_UZYTKOWNIK"));
                    uzytkownik.setImie(result.getString("IMIE"));
                    uzytkownik.setNazwisko(result.getString("NAZWISKO"));
                    uzytkownik.setLogin(result.getString("LOGIN"));
                    uzytkownik.setIdAdres(result.getInt("ID_ADRES"));
                    uzytkownik.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    uzytkownik.setNrDomu(result.getInt("NR_DOMU"));
                    uzytkownik.setNrLokalu(result.getInt("NR_LOKALU"));
                    uzytkownik.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    uzytkownik.setPoczta(result.getString("POCZTA"));
                    uzytkownik.setEmail(result.getString("EMAIL"));
                    uzytkownik.setTelefon(result.getString("TELEFON"));
                    uzytkownik.setIdUprawnienia(result.getInt("ID_UPRAWNIENIA"));
                    uzytkownik.setUprawnienie(result.getString("UPRAWNIENIE"));  
                    uzytkownicy.add(uzytkownik);
                }
                }catch(SQLException se){  
                    System.out.println(se.getMessage());
                    return null;
                }
       // Base.disconnect();
        return uzytkownicy;
    }
    
     public Uzytkownik PobierzUzytkownika(int id)
     {
         ResultSet result = null;
         Uzytkownik uzytkownik = new Uzytkownik();
         try{
         result = Base.stmt.executeQuery("SELECT US.IMIE AS IMIE, US.NAZWISKO AS NAZWISKO, "
                + "A.ID_ADRES AS ID_ADRES, A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, "
                + "US.LOGIN AS LOGIN, A.NR_LOKALU AS NR_LOKALU, A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA, "
                + "US.EMAIL AS EMAIL, US.TELEFON AS TELEFON, U.ID_UPRAWNIENIA AS ID_UPRAWNIENIA, U.UPRAWNIENIE AS UPRAWNIENIE "
                + "FROM UZYTKOWNIK US INNER JOIN ADRES A ON US.ID_ADRES=A.ID_ADRES "
                + "INNER JOIN UPRAWNIENIA U ON US.ID_UPRWNIENIA=U.ID_UPRAWNIENIA WHERE US.ID_UZYTKOWNIK="+id);
         if(result.next())
         {
                    uzytkownik.setImie(result.getString("IMIE"));
                    uzytkownik.setNazwisko(result.getString("NAZWISKO"));
                    uzytkownik.setLogin(result.getString("LOGIN"));
                    uzytkownik.setIdAdres(result.getInt("ID_ADRES"));
                    uzytkownik.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    uzytkownik.setNrDomu(result.getInt("NR_DOMU"));
                    uzytkownik.setNrLokalu(result.getInt("NR_LOKALU"));
                    uzytkownik.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    uzytkownik.setPoczta(result.getString("POCZTA"));
                    uzytkownik.setEmail(result.getString("EMAIL"));
                    uzytkownik.setTelefon(result.getString("TELEFON"));
                    uzytkownik.setIdUprawnienia(result.getInt("ID_UPRAWNIENIA"));
                    uzytkownik.setUprawnienie(result.getString("UPRAWNIENIE"));
         }
         else
         {
             return null;
         }
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
             return null;
         }
         return uzytkownik;
     }
     
     public void DodajUzytkownika(Uzytkownik user) 
     {
         int id_adres=0;
         ResultSet result = null;
         PreparedStatement statement;
         PreparedStatement statement2;
         try{
         statement2 = Base.conn.prepareStatement("INSERT INTO ADRES VALUES(NULL,?,?,?,?,?);");
         statement2.setString(1, user.getUlicaMiejscowosc());
         statement2.setInt(2, user.getNrDomu());
         statement2.setInt(3, user.getNrLokalu());
         statement2.setString(4, user.getKodPocztowy());
         statement2.setString(5, user.getPoczta());
         statement2.execute();
         result = Base.stmt.executeQuery("SELECT LAST_INSERT_ID() AS ID_ADRES");
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement = Base.conn.prepareStatement("INSERT INTO UZYTKOWNIK VALUES(NULL,?,?,?,?,?,?,?,?);");
         statement.setString(1, user.getLogin());
         statement.setString(2, user.getImie());
         statement.setString(3, user.getNazwisko());
         statement.setInt(4, id_adres);
         statement.setString(5, user.getEmail());
         statement.setString(6, user.getHaslo());
         statement.setString(7, user.getTelefon());
         statement.setInt(8, user.getIdUprawnienia());
         statement.execute();
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
     }
     
     public void UsunUzytkownika(int id) 
     {
         PreparedStatement statement1;
         PreparedStatement statement2;
         ResultSet result = null;
         int id_adres=0;
         try{
         result = Base.stmt.executeQuery("SELECT ID_ADRES FROM UZYTKOWNIK WHERE ID_UZYTKOWNIK="+id);
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement1 = Base.conn.prepareStatement("DELETE FROM UZYTKOWNIK WHERE ID_UZYTKOWNIK=?");
         statement1.setInt(1, id);         
         statement1.execute();
         statement2 = Base.conn.prepareStatement("DELETE FROM ADRES WHERE ID_ADRES=?");
         statement2.setInt(1, id_adres);         
         statement2.execute();
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
     }
     
     public Uzytkownik Logowanie(String login, String haslo)
     {
         ResultSet result = null;
         Uzytkownik uzytkownik = new Uzytkownik();
         try{
         result = Base.stmt.executeQuery("SELECT US.IMIE AS IMIE, US.NAZWISKO AS NAZWISKO, "
                + "A.ID_ADRES AS ID_ADRES, A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, "
                + "US.LOGIN AS LOGIN, A.NR_LOKALU AS NR_LOKALU, A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA, "
                + "US.EMAIL AS EMAIL, US.TELEFON AS TELEFON, U.ID_UPRAWNIENIA AS ID_UPRAWNIENIA, U.UPRAWNIENIE AS UPRAWNIENIE "
                + "FROM UZYTKOWNIK US INNER JOIN ADRES A ON US.ID_ADRES=A.ID_ADRES "
                + "INNER JOIN UPRAWNIENIA U ON US.ID_UPRWNIENIA=U.ID_UPRAWNIENIA WHERE US.LOGIN='"+login+"' AND US.HASLO='"+haslo+"'");
         if(result.next())
         {
                    uzytkownik.setImie(result.getString("IMIE"));
                    uzytkownik.setNazwisko(result.getString("NAZWISKO"));
                    uzytkownik.setLogin(result.getString("LOGIN"));
                    uzytkownik.setIdAdres(result.getInt("ID_ADRES"));
                    uzytkownik.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    uzytkownik.setNrDomu(result.getInt("NR_DOMU"));
                    uzytkownik.setNrLokalu(result.getInt("NR_LOKALU"));
                    uzytkownik.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    uzytkownik.setPoczta(result.getString("POCZTA"));
                    uzytkownik.setEmail(result.getString("EMAIL"));
                    uzytkownik.setTelefon(result.getString("TELEFON"));
                    uzytkownik.setIdUprawnienia(result.getInt("ID_UPRAWNIENIA"));
                    uzytkownik.setUprawnienie(result.getString("UPRAWNIENIE"));
         }
         else
         {
             return null;
         }
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
         return uzytkownik;
     } // jezeli autoryzacja przebiegla pomyslnie - zwraca obiekt uzytkownika, jesli nie - zwraca null
    
}
