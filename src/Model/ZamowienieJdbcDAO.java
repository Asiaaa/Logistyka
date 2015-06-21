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
public class ZamowienieJdbcDAO implements ZamowienieDAO {
    
    /* implementacja metod interfejsu ZamowienieDAO */
    BaseConnection Base = BaseConnection.getConnection();
    
    public Zamowienie PobierzZamowienie(int id_zamowienie)
    {
        Zamowienie zamowienie = new Zamowienie();
        Uzytkownik klient = new Uzytkownik();
        Przesylka przesylka = new Przesylka();
        ResultSet result = null;
        try{
         result = Base.stmt.executeQuery("SELECT US.ID_UZYTKOWNIK AS ID_UZYTKOWNIK, US.IMIE AS IMIE, US.NAZWISKO AS NAZWISKO, "
                + "A.ID_ADRES AS ID_ADRES, A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, "
                + "US.LOGIN AS LOGIN, A.NR_LOKALU AS NR_LOKALU, A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA, "
                + "US.EMAIL AS EMAIL, US.TELEFON AS TELEFON, Z.DATA_ZAMOWIENIA, S.STATUS, T.TYP_PRZESYLKI, PRZ.CENA "
                 + "FROM ZAMOWIENIE Z INNER JOIN UZYTKOWNIK US ON Z.ID_UZYTKOWNIK=US.ID_UZYTKOWNIK "
                 + "INNER JOIN ADRES A ON US.ID_ADRES=A.ID_ADRES "
                 + "INNER JOIN STATUS_ZAMOWIENIA S ON Z.ID_STATUS=S.ID_STATUS "
                 + "INNER JOIN TYP_PRZESYLKI T ON Z.ID_PRZESYLKA=T.ID_TYP_PRZESYLKI "
                 + "INNER JOIN PRZESYLKA PRZ ON T.ID_TYP_PRZESYLKI=PRZ.ID_TYP_PRZESYLKI WHERE Z.ID_ZAMOWIENIE="+id_zamowienie);
         if(result.next())
         {
                    klient.setIdUzytkownik(result.getInt("ID_UZYTKOWNIK"));
                    klient.setImie(result.getString("IMIE"));
                    klient.setNazwisko(result.getString("NAZWISKO"));
                    klient.setLogin(result.getString("LOGIN"));
                    klient.setIdAdres(result.getInt("ID_ADRES"));
                    klient.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    klient.setNrDomu(result.getInt("NR_DOMU"));
                    klient.setNrLokalu(result.getInt("NR_LOKALU"));
                    klient.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    klient.setPoczta(result.getString("POCZTA"));
                    klient.setEmail(result.getString("EMAIL"));
                    klient.setTelefon(result.getString("TELEFON"));
                    zamowienie.setUzytkownik(klient);
                    zamowienie.setData(result.getDate("DATA_ZAMOWIENIA"));
                    zamowienie.setStatus(result.getString("STATUS"));
                    przesylka.setTypPrzesylki(result.getString("TYP_PRZESYLKI"));
                    przesylka.setCena(result.getDouble("CENA"));
                    zamowienie.setPrzesylka(przesylka);
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
        return zamowienie;
    }
    
    public List<Zamowienie> PobierzZamowienia()
    {
        List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();
        Zamowienie zamowienie = new Zamowienie();
        Uzytkownik klient = new Uzytkownik();
        Przesylka przesylka = new Przesylka();
        ResultSet result = null;
        try{
         result = Base.stmt.executeQuery("SELECT US.ID_UZYTKOWNIK AS ID_UZYTKOWNIK, US.IMIE AS IMIE, US.NAZWISKO AS NAZWISKO, "
                + "A.ID_ADRES AS ID_ADRES, A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, "
                + "US.LOGIN AS LOGIN, A.NR_LOKALU AS NR_LOKALU, A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA, "
                + "US.EMAIL AS EMAIL, US.TELEFON AS TELEFON, Z.DATA_ZAMOWIENIA, S.STATUS, T.TYP_PRZESYLKI, PRZ.CENA "
                 + "FROM ZAMOWIENIE Z INNER JOIN UZYTKOWNIK US ON Z.ID_UZYTKOWNIK=US.ID_UZYTKOWNIK "
                 + "INNER JOIN ADRES A ON US.ID_ADRES=A.ID_ADRES "
                 + "INNER JOIN STATUS_ZAMOWIENIA S ON Z.ID_STATUS=S.ID_STATUS "
                 + "INNER JOIN TYP_PRZESYLKI T ON Z.ID_PRZESYLKA=T.ID_TYP_PRZESYLKI "
                 + "INNER JOIN PRZESYLKA PRZ ON T.ID_TYP_PRZESYLKI=PRZ.ID_TYP_PRZESYLKI");
         if(result.next())
         {
                    klient.setIdUzytkownik(result.getInt("ID_UZYTKOWNIK"));
                    klient.setImie(result.getString("IMIE"));
                    klient.setNazwisko(result.getString("NAZWISKO"));
                    klient.setLogin(result.getString("LOGIN"));
                    klient.setIdAdres(result.getInt("ID_ADRES"));
                    klient.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    klient.setNrDomu(result.getInt("NR_DOMU"));
                    klient.setNrLokalu(result.getInt("NR_LOKALU"));
                    klient.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    klient.setPoczta(result.getString("POCZTA"));
                    klient.setEmail(result.getString("EMAIL"));
                    klient.setTelefon(result.getString("TELEFON"));
                    zamowienie.setUzytkownik(klient);
                    zamowienie.setData(result.getDate("DATA_ZAMOWIENIA"));
                    zamowienie.setStatus(result.getString("STATUS"));
                    przesylka.setTypPrzesylki(result.getString("TYP_PRZESYLKI"));
                    przesylka.setCena(result.getDouble("CENA"));
                    zamowienie.setPrzesylka(przesylka);
                    zamowienia.add(zamowienie);
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
        return zamowienia;
    }
    
    public List<Produkt> PobierzListeProduktow(int id_zamowienia)
    {
        List<Produkt> produkty = new ArrayList<Produkt>();
        Produkt produkt = new Produkt();
        ResultSet result = null;
        try{
        result = Base.stmt.executeQuery("SELECT P.NAZWA, P.CENA, R.ROZMIAR, T.TYP, K.KOLOR, KP.ILOSC "
                + "FROM KOSZYK KSZ INNER JOIN ZAMOWIENIE Z ON KSZ.ID_KOSZYK=Z.ID_KOSZYK "
                + "INNER JOIN KOSZYK_PRODUKT KP ON KSZ.ID_KOSZYK_PRODUKT=KP.ID_KOSZYK_PRODUKT "
                + "INNER JOIN PRODUKT P ON KP.ID_PRODUKT=P.ID_PRODUKTU "
                + "INNER JOIN ROZMIAR R ON P.ID_ROZMIAR=R.ID_ROZMIAR "
                + "INNER JOIN TYP T ON P.ID_TYP=T.ID_TYP "
                + "INNER JOIN KOLOR K ON P.ID_KOLOR=K.ID_KOLOR WHERE Z.ID_ZAMOWIENIE="+id_zamowienia);
        if(result.next())
         {
                    produkt.setNazwa(result.getString("NAZWA"));
                    produkt.setCena(result.getDouble("CENA"));
                    produkt.setRozmiar(result.getString("ROZMIAR"));
                    produkt.setTyp(result.getString("TYP"));
                    produkt.setKolor(result.getString("KOLOR"));
                    produkt.setIlosc(result.getInt("ILOSC"));
                    produkty.add(produkt);
         }
         else
         {
             return null;
         }
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return produkty;
    }
    
    public void UsunZamowienie(int id_zamowienia)
    {
        PreparedStatement statement;
        try{
        statement = Base.conn.prepareStatement("DELETE FROM ZAMOWIENIE WHERE ID_ZAMOWIENIE=?");
        statement.setInt(1, id_zamowienia);         
        statement.execute();
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
    }
    
     public void ZmienStatus(int id_zamowienie, int id_status)
     {
         PreparedStatement statement;
        try{
        statement = Base.conn.prepareStatement("UPDATE ZAMOWIENIE SET ID_STATUS=? WHERE ID_ZAMOWIENIE=?");
        statement.setInt(1, id_status);
        statement.setInt(2, id_zamowienie);         
        statement.execute();
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
     }
     
     public Przesylka PobierzPrzesylka (int id_zamowienie)
     {
        Przesylka przesylka = new Przesylka();
        ResultSet result = null;
        try{
        result = Base.stmt.executeQuery("SELECT P.ID_PRZESYLKA, P.CENA, T.TYP_PRZESYLKI "
                + "FROM PRZESYLKA P INNER JOIN TYP_PRZESYLKI T ON P.ID_TYP_PRZESYLKI=T.ID_TYP_PRZESYLKI "
                + "INNER JOIN ZAMOWIENIE Z ON P.ID_PRZESYLKA=Z.ID_PRZESYLKA WHERE ID_ZAMOWIENIE="+id_zamowienie);  
        
        if(result.next())
         {
                    przesylka.setIdPrzesylka(result.getInt("ID_PRZESYLKA"));
                    przesylka.setCena(result.getDouble("CENA"));
                    przesylka.setTypPrzesylki(result.getString("TYP_PRZESYLKI"));
         }
         else
         {
             return null;
         }
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return przesylka;
     }
}
