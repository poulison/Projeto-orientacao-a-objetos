/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Investidor;
import view.Contas;

/**
 *
 * @author Paulo
 */
public class ControllerContas {
    private Contas view;
    private Investidor investidor; 
    
    public ControllerContas(Contas view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
}
