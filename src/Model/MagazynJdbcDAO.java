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
public class MagazynJdbcDAO {
    
    BaseConnection Base = BaseConnection.getConnection();
    
    /*implementacja metod interfejsu MagazynDAO */
    
    public List<Magazyn> PobierzMagazyny()
    {
         List<Magazyn> magazyny = new ArrayList<Magazyn>();
         Magazyn magazyn = new Magazyn();
         ResultSet result = null;
         try{
         result = Base.stmt.executeQuery("SELECT M.ID_MAGAZYN AS ID_MAGAZYN, M.NAZWA AS NAZWA, M.ID_ADRES AS ID_ADRES, "
                 + "A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, A.NR_LOKALU AS NR_LOKALU, "
                 + "A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA FROM MAGAZYN M "
                 + "INNER JOIN ADRES A ON M.ID_ADRES=A.ID_ADRES");
         if(result.next())
         {
                    magazyn.setNazwa(result.getString("NAZWA"));
                    magazyn.setIdAdres(result.getInt("ID_ADRES"));
                    magazyn.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    magazyn.setNrDomu(result.getInt("NR_DOMU"));
                    magazyn.setNrLokalu(result.getInt("NR_LOKALU"));
                    magazyn.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    magazyn.setPoczta(result.getString("POCZTA"));
                    magazyny.add(magazyn);
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
         return magazyny;
    }
    
     public Magazyn PobierzMagazyn(int id)
     {
         ResultSet result = null;
         Magazyn magazyn = new Magazyn();
         try{
         result = Base.stmt.executeQuery("SELECT M.ID_MAGAZYN AS ID_MAGAZYN, M.NAZWA AS NAZWA, M.ID_ADRES AS ID_ADRES, "
                 + "A.ULICA_MIEJSCOWOSC AS ULICA_MIEJSCOWOSC, A.NR_DOMU AS NR_DOMU, A.NR_LOKALU AS NR_LOKALU, "
                 + "A.KOD_OCZTOWY AS KOD_POCZTOWY, A.POCZTA AS POCZTA FROM MAGAZYN M "
                 + "INNER JOIN ADRES A ON M.ID_ADRES=A.ID_ADRES WHERE M.ID_MAGAZYN="+id);
         if(result.next())
         {
                    magazyn.setNazwa(result.getString("NAZWA"));
                    magazyn.setIdAdres(result.getInt("ID_ADRES"));
                    magazyn.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                    magazyn.setNrDomu(result.getInt("NR_DOMU"));
                    magazyn.setNrLokalu(result.getInt("NR_LOKALU"));
                    magazyn.setKodPocztowy(result.getString("KOD_POCZTOWY"));
                    magazyn.setPoczta(result.getString("POCZTA"));
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
         return magazyn;
     }
     
     public void DodajMagazyn(Magazyn magazyn)
     {
         int id_adres=0;
         ResultSet result = null;
         PreparedStatement statement;
         PreparedStatement statement2;
         try{
         statement2 = Base.conn.prepareStatement("INSERT INTO ADRES VALUES(NULL,?,?,?,?,?);");
         statement2.setString(1, magazyn.getUlicaMiejscowosc());
         statement2.setInt(2, magazyn.getNrDomu());
         statement2.setInt(3, magazyn.getNrLokalu());
         statement2.setString(4, magazyn.getKodPocztowy());
         statement2.setString(5, magazyn.getPoczta());
         statement2.execute();
         result = Base.stmt.executeQuery("SELECT LAST_INSERT_ID() AS ID_ADRES");
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement = Base.conn.prepareStatement("INSERT INTO MAGAZYN VALUES(NULL,?,?);");
         statement.setString(1, magazyn.getNazwa());
         statement.setInt(2, id_adres);
         statement.execute();
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
     }
     
      public void UsunMagazyn(int id)
      {
         PreparedStatement statement1;
         PreparedStatement statement2;
         ResultSet result = null;
         int id_adres=0;
         try{
         result = Base.stmt.executeQuery("SELECT ID_ADRES FROM MAGAZYN WHERE ID_MAGAZYN="+id);
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement1 = Base.conn.prepareStatement("DELETE FROM MAGAZYN WHERE ID_MAGAZYN=?");
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
      
       public List<Produkt> PobierzListeProduktow(int id_magazynu)
       {
         List<Produkt> produkty = new ArrayList<Produkt>();
         Produkt produkt = new Produkt();
         
         ResultSet result = null;
         try{
         result = Base.stmt.executeQuery("SELECT P.NAZWA, P.CENA, K.KATEGORIA, M.MARKA, KO.KOLOR, R.ROZMIAR, T.TYP, PRZ.ILOSC "
                 + "FROM PRODUKT P INNER JOIN KATEGORIA K ON P.ID_KATEGORIA=K.ID_KATEGORIA "
                 + "INNER JOIN KOLOR KO ON P.ID_KOLOR=KO.ID_KOLOR "
                 + "INNER JOIN MARKA M ON P.ID_MARKA=M.ID_MARKI "
                 + "INNER JOIN ROZMIAR R ON P.ID_ROZMIAR=R.ID_ROZMIAR "
                 + "INNER JOIN TYP T ON P.ID_TYP=T.ID_TYP "
                 + "INNER JOIN PRZECHOWYWANIE PRZ ON P.ID_PRODUKTU=PRZ.ID_PRODUKT "
                 + "WHERE ID_PRODUKT IN(SELECT PR.ID_PRODUKT FROM PRZECHOWYWANIE PR WHERE PR.ID_MAGAZYN="+id_magazynu);
         if(result.next())
         {
                    produkt.setNazwa(result.getString("NAZWA"));
                    produkt.setCena(result.getInt("CENA"));
                    produkt.setKategoria(result.getString("KATEGORIA"));
                    produkt.setMarka(result.getString("MARKA"));
                    produkt.setKolor(result.getString("KOLOR"));
                    produkt.setRozmiar(result.getString("ROZMIAR"));
                    produkt.setTyp(result.getString("TYP"));
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
             return null;
         }
         return produkty;
       }
     
}
