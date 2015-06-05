/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

/**
 *
 * @author Joanna
 */
public class Magazyn {
    public int id_magazyn;
    public String nazwa;
  // private int ilosc;
    private List<Produkt> lista_produktow;
    
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
}

