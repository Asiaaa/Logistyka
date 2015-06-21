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
public class Produkt {
    public int id_produktu;
    private String nazwa;
    private double cena;
    private int id_kategoria;
    private String kategoria;
    private int id_marka;
    private String marka;
    private int id_kolor;
    private String kolor;
    private int id_rozmiar;
    private String rozmiar;
    private int id_typ;
    private String typ;
    private int ilosc;
    
    
    public void setNazwa(String nazwa)
    {
        this.nazwa=nazwa;
    }
    
    public String getNazwa()
    {
        return nazwa;
    }
    
    public void setCena(double cena)
    {
        this.cena=cena;
    }
    
    public double getCena()
    {
         return cena;
    }
    
    public void setIdKategoria(int id)
    {
        id_kategoria=id;
    }
    
    public int getIdKategoria()
    {
        return id_kategoria;
    }
    
    public void setKategoria(String kat)
    {
        kategoria=kat;
    }
    
    public String getKategoria()
    {
        return kategoria;
    }
    
    public void setIdMarka(int id)
    {
        id_marka=id;
    }
    
    public int getIdMarka()
    {
        return id_marka;
    }
    
    public void setMarka(String marka)
    {
        this.marka=marka;
    }
    
    public String getMarka()
    {
        return marka;
    }
    
    public void setIdKolor(int idkolor)
    {
        this.id_kolor=idkolor;
    }
    
    public int getIdKolor()
    {
        return id_kolor;
    }
    
    public void setKolor(String kolor)
    {
        this.kolor=kolor;
    }
    
    public String getKolor()
    {
        return kolor;
    }
    
    public void setIdRozmiar(int id)
    {
        this.id_rozmiar=id;
    }
    
    public int getIdRozmiar()
    {
        return id_rozmiar;
    }
    
    public void setRozmiar(String rozmiar)
    {
        this.rozmiar=rozmiar;
    }
    
    public String getRozmiar()
    {
        return rozmiar;
    }
    
    public void setIdTyp(int id)
    {
        id_typ=id;
    }
    
    public int getIdTyp()
    {
        return id_typ;
    }
    
    public void setTyp(String typ)
    {
        this.typ=typ;
    }
    
    public String getTyp()
    {
        return typ;
    }
    
    public void setIlosc(int ilosc)
    {
        this.ilosc=ilosc;
    }
    
    public int getIlosc()
    {
        return ilosc;
    }
    
}
