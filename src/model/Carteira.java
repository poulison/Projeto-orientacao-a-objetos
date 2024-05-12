/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class Carteira {
    ArrayList<Moedas> moedas = new ArrayList<Moedas>();
   
    public Carteira(){
        moedas = new ArrayList<Moedas>();
        moedas.add(new Real(0,0));
        
        
        
    }
    
    public Carteira(ArrayList<Moedas> moedas){
        
    }
    
}
