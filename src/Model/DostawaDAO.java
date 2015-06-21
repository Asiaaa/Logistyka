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
public interface DostawaDAO {
    
    public List<Dostawa> PobierzDostawy();
    /* pobiera liste dostaw z bazy danych */
    
    public List<Dostawca> PobierzDostawcow();
    /* pobiera listę dostawców z bazy danych */
    
    public Dostawa PobierzDostawe(int id_dostawy);
    /* pobiera dostawę o podanym id */
    
    public Dostawca PobierzDostawce(int id_dostawa);
    /* pobiera dostawcę dostawy i podanym id */
    
    public void DodajDostawce(Dostawca dostawca);
    /* dodaje dostawcę do bazy danych */
    
    public void UsunDostawce(int id_dostawcy);
    /* usuwa dostawcę z bazy danych */
    
    public void DodajDostawe(Dostawa dostawa);
    /* dodaje dostawę do bazy danych - może być róznoznaczne z robieniem zamówienia do dostawcy */
    
    public void UsunDostawe(int id_dostawy);
    /* usuwa dostawę z bazy danych - może byc równoznaczne z dostarczoną dostawą 
    - uruchomienie triggera dla tej akcji zapisującego dostawę do archiwum dostaw*/
    
    public List<Produkt> PobierzProdukty(int id_dostawy);
    /* pobiera listę produktów dla dostawy o podanym id */
    
   /* dodac ewentualne brakujace metody
    
    Moglyby miec jeszcze status */
    
   
}
