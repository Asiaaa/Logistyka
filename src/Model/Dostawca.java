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
public class Dostawca {
    public int id_dostawca;
    private String nazwa_firmy;
    private String nip;
    private String ulica_miejscowosc;
    private int nr_domu;
    private int nr_lokalu;
    private String kod_pocztowy;
     private String poczta;
    
    public void setIdDostawca(int id)
    {
        this.id_dostawca=id;
    }
    
    public int getIdDostawca()
    {
        return id_dostawca;
    }
    
    public void setNazwaFirmy(String nazwa)
    {
        this.nazwa_firmy=nazwa;
    }
    
    public String getNazwaFirmy()
    {
        return nazwa_firmy;
    }
    
    public void setNip(String nip)
    {
        this.nip=nip;
    }
    
    public String getNip()
    {
        return nip;
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
