/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Paulo
 */
public class Ripple extends Moedas implements Tarifacao{
    private static final double taxaCompra = 0.01;
    private static final double taxaVenda = 0.01;
    
    public Ripple(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Ripple(){
        
    }
    
    @Override
    public double getTaxaCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getTaxaVenda() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
