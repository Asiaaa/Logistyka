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
public interface ZamowienieDAO {
    
    public List<Zamowienie> PobierzZamowienia();
    /* pobierz listę zamówień z bazy danych */
    
    public Zamowienie PobierzZamowienie(int id);
    /* pobierz zamówienie o danym id z bazy danych */
    
    public List<Produkt> PobierzListeProduktow(int id_zamowienia);
    /* pobierz listę produktów zamówienia o danym id */
    
    public void UsunZamowienie(int id_zamowienia);
    /* usuwa zamowienie z bazy danych */
    
    public void ZmienStatus(int id_zamowienie, int id_status);
    /* zmienia status zamowienia */
    
    public Przesylka PobierzPrzesylka (int id_zamowienie);
    /* pobiera informacje o przesylce z zamowienia o danym id */
    
    /* dodać ewentualne brakujące metody 
    
    Modul glownie obslugiwany w aplikacji internetowej
    
    Zawiera również informacje o sposobie przesyłki
    */
}
