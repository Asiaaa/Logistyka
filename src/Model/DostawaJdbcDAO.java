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
public class DostawaJdbcDAO implements DostawaDAO{
     
   /* implementacja metod interfejsu DostawaDAO */
    BaseConnection Base = BaseConnection.getConnection();
    
    public List<Dostawa> PobierzDostawy()
    {
        List<Dostawa> dostawy = new ArrayList<Dostawa>();
        Dostawa dostawa = new Dostawa();
        Dostawca dostawca = new Dostawca();
        ResultSet result = null;
        try{
            result = Base.stmt.executeQuery("SELECT D.ID_DOSTAWA, D.DATA_DOSTAWY, DA.NAZWA_FIRMY, DA.NIP, "
                    + "A.ULICA_MIEJSCOWOSC, A.NR_DOMU, A.NR_LOKALU, A.KOD_OCZTOWY, A.POCZTA FROM DOSTAWA D " 
                    +  "INNER JOIN DOSTAWCA DA ON DA.ID_DOSTAWCA=D.ID_DOSTAWCA "
                    + "INNER JOIN ADRES A ON A.ID_ADRES=DA.ID_ADRES");
         if(result.next())
         {
                dostawca.setNazwaFirmy(result.getString("NAZWA_FIRMY"));
                dostawca.setNip(result.getString("NIP"));
                dostawca.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                dostawca.setNrDomu(result.getInt("NR_DOMU"));
                dostawca.setNrLokalu(result.getInt("NR_LOKALU"));
                dostawca.setKodPocztowy(result.getString("KOD_OCZTOWY"));
                dostawca.setPoczta(result.getString("POCZTA"));
                dostawa.setDostawca(dostawca);
                dostawa.setIdDostawa(result.getInt("ID_DOSTAWA"));
                dostawa.setDataDostawy(result.getDate("DATA_DPSTAWY"));
                dostawy.add(dostawa);       
         } 
         else
             return null;
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return dostawy;
    }
    
    public List<Dostawca> PobierzDostawcow()
    {
        List<Dostawca> dostawcy = new ArrayList<Dostawca>();
        Dostawca dostawca = new Dostawca();
        ResultSet result = null;
        try{
            result = Base.stmt.executeQuery("SELECT DA.ID_DOSTAWCA, DA.NAZWA_FIRMY, DA.NIP, A.ULICA_MIEJSCOWOSC, "
                    + "A.NR_DOMU, A.NR_LOKALU, A.KOD_OCZTOWY, A.POCZTA FROM DOSTAWCA DA INNER JOIN ADRES A ON A.ID_ADRES=DA.ID_ADRES");
         if(result.next())
         {
                dostawca.setIdDostawca(result.getInt("ID_DOSTAWCA"));
                dostawca.setNazwaFirmy(result.getString("NAZWA_FIRMY"));
                dostawca.setNip(result.getString("NIP"));
                dostawca.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                dostawca.setNrDomu(result.getInt("NR_DOMU"));
                dostawca.setNrLokalu(result.getInt("NR_LOKALU"));
                dostawca.setKodPocztowy(result.getString("KOD_OCZTOWY"));
                dostawca.setPoczta(result.getString("POCZTA"));
                dostawcy.add(dostawca);       
         } 
         else
             return null;
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return dostawcy;
    }
    
    public Dostawa PobierzDostawe(int id_dostawy)
    {
        Dostawa dostawa = new Dostawa();
        Dostawca dostawca = new Dostawca();
        ResultSet result = null;
        try{
            result = Base.stmt.executeQuery("SELECT D.ID_DOSTAWA, D.DATA_DOSTAWY, DA.NAZWA_FIRMY, DA.NIP, A.ULICA_MIEJSCOWOSC, "
                    + "A.NR_DOMU, A.NR_LOKALU, A.KOD_OCZTOWY, A.POCZTA FROM DOSTAWA D "
                    + "INNER JOIN DOSTAWCA DA ON DA.ID_DOSTAWCA=D.ID_DOSTAWCA "
                    + "INNER JOIN ADRES A ON A.ID_ADRES=DA.ID_ADRES WHERE D.ID_DOSTAWA="+id_dostawy);
         if(result.next())
         {
                dostawca.setNazwaFirmy(result.getString("NAZWA_FIRMY"));
                dostawca.setNip(result.getString("NIP"));
                dostawca.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                dostawca.setNrDomu(result.getInt("NR_DOMU"));
                dostawca.setNrLokalu(result.getInt("NR_LOKALU"));
                dostawca.setKodPocztowy(result.getString("KOD_OCZTOWY"));
                dostawca.setPoczta(result.getString("POCZTA"));
                dostawa.setDostawca(dostawca);
                dostawa.setIdDostawa(result.getInt("ID_DOSTAWA"));
                dostawa.setDataDostawy(result.getDate("DATA_DPSTAWY"));      
         } 
         else
             return null;
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return dostawa;
    }
    
    public Dostawca PobierzDostawce(int id_dostawa)
    {
        Dostawca dostawca = new Dostawca();
        ResultSet result = null;
        try{
            result = Base.stmt.executeQuery("SELECT DA.ID_DOSTAWCA, DA.NAZWA_FIRMY, DA.NIP, A.ULICA_MIEJSCOWOSC, A.NR_DOMU, A.NR_LOKALU, "
                    + "A.KOD_OCZTOWY, A.POCZTA FROM DOSTAWCA DA INNER JOIN ADRES A ON A.ID_ADRES=DA.ID_ADRES "
                    + "INNER JOIN DOSTAWA D ON D.ID_DOSTAWCA=DA.ID_DOSTAWCA WHERE D.ID_DOSTAWA="+id_dostawa);
         if(result.next())
         {
                dostawca.setIdDostawca(result.getInt("ID_DOSTAWCA"));
                dostawca.setNazwaFirmy(result.getString("NAZWA_FIRMY"));
                dostawca.setNip(result.getString("NIP"));
                dostawca.setUlicaMiejscowosc(result.getString("ULICA_MIEJSCOWOSC"));
                dostawca.setNrDomu(result.getInt("NR_DOMU"));
                dostawca.setNrLokalu(result.getInt("NR_LOKALU"));
                dostawca.setKodPocztowy(result.getString("KOD_OCZTOWY"));
                dostawca.setPoczta(result.getString("POCZTA"));      
         } 
         else
             return null;
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return dostawca;
    }
    
    public void DodajDostawce(Dostawca dostawca)
    {
         ResultSet result = null;
         PreparedStatement statement2;
         PreparedStatement statement1;
         int id_adres=0;
         try{
         statement2 = Base.conn.prepareStatement("INSERT INTO ADRES VALUES(NULL,?,?,?,?,?);");
         statement2.setString(1, dostawca.getUlicaMiejscowosc());
         statement2.setInt(2, dostawca.getNrDomu());
         statement2.setInt(3, dostawca.getNrLokalu());
         statement2.setString(4, dostawca.getKodPocztowy());
         statement2.setString(5, dostawca.getPoczta());
         statement2.execute();
         result = Base.stmt.executeQuery("SELECT LAST_INSERT_ID() AS ID_ADRES");
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement1 = Base.conn.prepareStatement("INSERT INTO DOSTAWCA VALUES(NULL,?,?,?);");
         statement1.setString(1, dostawca.getNazwaFirmy());
         statement1.setString(2, dostawca.getNip());
         statement1.setInt(2, id_adres);
         statement1.execute();
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
    }
    
    public void UsunDostawce(int id_dostawcy)
    {
         PreparedStatement statement1;
         PreparedStatement statement2;
         ResultSet result = null;
         int id_adres=0;
         try{
         result = Base.stmt.executeQuery("SELECT ID_ADRES FROM DOSTAWCA WHERE ID_DOSTAWCA="+id_dostawcy);
         if(result.next())
         {
             id_adres=result.getInt("ID_ADRES");
         }
         statement1 = Base.conn.prepareStatement("DELETE FROM DOSTAWCA WHERE ID_DOSTAWCA=?");
         statement1.setInt(1, id_dostawcy);         
         statement1.execute();
         statement2 = Base.conn.prepareStatement("DELETE FROM ADRES WHERE ID_ADRES=?");
         statement2.setInt(1, id_adres);         
         statement2.execute();
         }catch(SQLException se)
         {
             System.out.println(se.getMessage());
         }
    }
    
    public void DodajDostawe(Dostawa dostawa)
    {
        // lista produktow
    }
    
    public void UsunDostawe(int id_dostawy)
    {
        // ...
    }
    
     public List<Produkt> PobierzProdukty(int id_dostawy)
     {
         List<Produkt> produkty = new ArrayList<Produkt>();
         // ..
         return produkty;
         
     }
    
}
