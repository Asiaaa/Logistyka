/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 * @author adrian
 */
public class LoginController {
    private Start theStart;
    private Nav theNav;
    
    public LoginController(Start theStart, Nav theNav){
        this.theStart = theStart;
        this.theNav=theNav;
        this.theStart.setVisible(true);
        this.theNav.setVisible(false);
        this.theStart.addLOGINListener(new IN_LOGINListener());
    }
    
    class IN_LOGINListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            
                String login=theStart.getLogin();
                String haslo=theStart.getPassword();  // do tych zmiennych przypisac login i haslo pobrane z widoku

                UzytkownikJdbcDAO dao = new UzytkownikJdbcDAO();
                Uzytkownik user = new Uzytkownik();
                user=dao.Logowanie(login, haslo); /* w user jest obiekt uzytkownika ze wszytskimi jego danymi albo null 
                                                       jesli haslo nie zgadza sie z loginem albo odwrotnie */
                if(user!=null){
                     //utoryzacja pomyslna
                    theStart.setVisible(false);
                    theNav.setVisible(true);
                }
                else theStart.showERROR();        
        }    
    }
}
