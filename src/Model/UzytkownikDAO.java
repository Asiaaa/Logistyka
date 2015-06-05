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
public interface UzytkownikDAO {
    
    public List<Uzytkownik> PobierzUzytkownikow();
    /* pobiera listę wszystkich użytkowników
        z bazy danych */
    
    public Uzytkownik PobierzUzytkownika(int id);
    /* wybiera użytkownika po id_uzytkownik */
    
    public void DodajUzytkownika(Uzytkownik user);
    /* dodaje użytkownika do bazy danych */
    
    public void UsunUzytkownika(int id);
    /* usuwa użytkownika o podanym id z bazy danych */
       
    /* dodac ewentualne brakujace metody */
}
