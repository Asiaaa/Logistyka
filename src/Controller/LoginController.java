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
    
    public LoginController(Start theStart){
        this.theStart = theStart;
        this.theStart.setVisible(true);
        this.theStart.addLOGINListener(new IN_LOGINListener());
    }
    
    class IN_LOGINListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            
                //theStart.getLogin(), 
                //theStart.getPassword());
                Uzytkownik user = new Uzytkownik();
                if(user!=null){
                     //utoryzacja pomyslna
                }
                else theStart.showERROR();        
        }    
    }
}
