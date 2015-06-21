/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Joanna
 */
public class Dostawa {
    public int id_dostawa;
    private Dostawca dostawca;
    private Date data_dostawy;
    private List<Produkt> lista_produktow;
    
    public void setIdDostawa(int id)
    {
        id_dostawa=id;
    }
    
    public int getIdDostawa()
    {
        return id_dostawa;
    }
    
    public void setDostawca(Dostawca dostawca)
    {
        this.dostawca=dostawca;
    }
    
    public Dostawca getDostawca()
    {
        return dostawca;
    }
    
    public void setDataDostawy(Date data)
    {
        data_dostawy=data;
    }
    
    public Date getDataDostawy()
    {
        return data_dostawy;
    }
    
    public void setListaProduktow(List<Produkt> lista)
    {
        lista_produktow=lista;
    }
    
    public List<Produkt> getListaProduktow()
    {
        return lista_produktow;
    }
}
