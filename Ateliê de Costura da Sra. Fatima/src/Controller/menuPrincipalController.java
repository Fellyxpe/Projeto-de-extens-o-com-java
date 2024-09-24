/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.Agenda;
import view.MenuPrincipal;

/**
 *
 * @author darkm
 */
public class menuPrincipalController {
    
    private final MenuPrincipal view;

    public menuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    public void navegarParaAgenda(){
        
        Agenda agenda = new Agenda();
        agenda.setVisible (true);
        
    }
    
}
