/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joanna
 */
public class Magazyn {
    public int id_magazyn;
    public String nazwa;
  // private int ilosc;
    private int id_adres;
    private String ulica_miejscowosc;
    private int nr_domu;
    private int nr_lokalu;
    private String kod_pocztowy;
    private String poczta;
    public List<Produkt> lista_produktow=new ArrayList<Produkt>();
    
    public void setIdMagazyn(int id)
    {
        id_magazyn=id;
    }
    
    public int getIdMagazyn()
    {
        return id_magazyn;
    }
    
    public void setNazwa(String nazwa)
    {
        this.nazwa=nazwa;
    }
    
    public String getNazwa()
    {
        return nazwa;
    }
    
    public void setListaProduktow(List<Produkt> lista)
    {
        this.lista_produktow=lista;
    }
    
    public List<Produkt> getListaProduktow()
    {
        return lista_produktow;
    }
    
    public void setIdAdres(int id)
    {
        id_adres=id;
    }
    
    public int getIdAdres()
    {
        return id_adres;
    }
    
    public void setUlicaMiejscowosc(String um)
    {
        ulica_miejscowosc=um;
    }
    
    public String getUlicaMiejscowosc()
    {
        return ulica_miejscowosc;
    }
    
    public void setNrDomu(int nr)
    {
        nr_domu=nr;
    }
    
    public int getNrDomu()
    {
        return nr_domu;
    }
    
    public void setNrLokalu(int nr)
    {
        nr_lokalu=nr;
    }
    
    public int getNrLokalu()
    {
        return nr_lokalu;
    }
    
    public void setKodPocztowy(String kod)
    {
        kod_pocztowy=kod;
    }
    
    public String getKodPocztowy()
    {
        return kod_pocztowy;
    }
    
    public void setPoczta(String poczta)
    {
        this.poczta=poczta;
    }
    
    public String getPoczta()
    {
        return poczta;
    }
}

