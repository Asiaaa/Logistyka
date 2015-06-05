/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Joanna
 */
public class Przesylka {
    public int id_przesylka;
    private double cena;
    private int id_typ_przesylki;
    private String typ_przesylki;
    
    public void setIdPrzesylka(int id)
    {
        id_przesylka=id;
    }
    
    public int getIdPrzesylka()
    {
        return id_przesylka;
    }
    
    public void setCena(double cena)
    {
        this.cena=cena;
    }
    
    public double getCena()
    {
        return cena;
    }
    
    public void setIdTypPrzesylki(int id)
    {
        id_typ_przesylki=id;
    }
    
    public int getIdTypPrzesylki()
    {
        return id_typ_przesylki;
    }
    
    public void setTypPrzesylki(String typ)
    {
        this.typ_przesylki=typ;
    }
    
    public String getTypPrzesylki()
    {
        return typ_przesylki;
    }
}

