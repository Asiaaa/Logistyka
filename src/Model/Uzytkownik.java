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
public class Uzytkownik {
    public int id_uzytkownik;
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private int id_adres;
    private String ulica_miejscowosc;
    private int nr_domu;
    private int nr_lokalu;
    private String kod_pocztowy;
    private String poczta;
    private String email;
    private String telefon;
    private int id_uprawnienia;
    private String uprawnienie;
    
    public void setIdUzytkownik(int id)
    {
        id_uzytkownik=id;
    }
    
    public int getIdUzytkownik()
    {
        return id_uzytkownik;
    }
    
    public void setImie(String imie)
    {
        this.imie=imie;
    }
    
    public String getImie()
    {
        return imie;
    }
    
    public void setNazwisko(String nazwisko)
    {
        this.nazwisko=nazwisko;
    }
    
    public String getNazwisko()
    {
        return nazwisko;
    }
    
    public void setLogin(String login)
    {
        this.login=login;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public void setHaslo(String haslo)
    {
        this.haslo=haslo;
    }
    
    public String getHaslo()
    {
        return haslo;
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
    
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public void setPoczta(String poczta)
    {
        this.poczta=poczta;
    }
    
    public String getPoczta()
    {
        return poczta;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setTelefon(String tel)
    {
        telefon=tel;
    }
    
    public String getTelefon()
    {
        return telefon;
    }
    
    public void setIdUprawnienia(int id)
    {
        this.id_uprawnienia=id;
    }
    
    public int getIdUprawnienia()
    {
        return id_uprawnienia;
    }
    
    public void setUprawnienie(String uprawnienie)
    {
        this.uprawnienie=uprawnienie;
    }
    
    public String getUprawnienie()
    {
        return uprawnienie;
    }
}
