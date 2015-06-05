/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author Joanna
 */
public class Zamowienie { 
    public int id_zamowienie;
    private Uzytkownik uzytkownik;
    private Date data;
    private Przesylka przesylka;
    private int id_status;
    private String status;
    
    public void setIdZamowienie(int id)
    {
        id_zamowienie=id;
    }
    
    public int getIdZamowienie()
    {
        return id_zamowienie;
    }
    
    public void setUzytkownik(Uzytkownik user)
    {
        this.uzytkownik=user;
    }
    
    public Uzytkownik getUzytkownik()
    {
        return uzytkownik;
    }
    
    public void setData(Date data)
    {
        this.data=data;
    }
    
    public Date getData()
    {
        return data;
    }
    
    public void setPrzesylka(Przesylka przesylka)
    {
        this.przesylka=przesylka;
    }
    
    public Przesylka getPrzesylka()
    {
        return przesylka;
    }
    
    public void setIdStatus(int id_status)
    {
        this.id_status=id_status;
    }
    
    public int getIdStatus()
    {
        return id_status;
    }
    
    public void setStatus(String status)
    {
        this.status=status;
    }
    
    public String getStatus()
    {
        return status;
    }
}
