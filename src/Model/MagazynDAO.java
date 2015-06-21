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
public interface MagazynDAO {
    
    public List<Magazyn> PobierzMagazyny();
    /* pobiera listę magazynów z bazy danych */
    
    public Magazyn PobierzMagazyn(int id);
    /* pobiera magazyn o podanym id z bazy danych */
    
    public void DodajMagazyn(Magazyn magazyn);
    /* dodaje magazyn do bazy danych */
    
    public void UsunMagazyn(int id);
    /* usuwa magazyn o podanym id z bazy danych */
    
    public List<Produkt> PobierzListeProduktow(int id_magazynu);
    /* pobiera liste produktow magazynu o podanym id */
    
    public void DodajProdukt(int id_magazynu, Produkt produkt, int ilosc);
    /* dodaje produkt do listy magazynu o podanym id */
    
    //public void DodajProdukt(int id_magazynu, List<Produkt> lista); niezaimplementowane
    /* dodaje liste produktow do listy mahazynu o podanym id */
    
    public void UsunProdukt(int id_magazynu, int id_produktu);
    /* usuwa produkt z listy magazynu o podanym id */
    
    public int SprawdzDostepnosc(int id_magazyn, String nazwa_produktu);
    /* sprawdza dostepnosc podanego produktu w magazynie o podanym id - zwraca ilosc produktu, w przypadku braku
                                                                                    zwraca 0 */
    
    /* dodać ewentualne brakujące metody */
        
}
