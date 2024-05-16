/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Paulo
 */
public class Bitcoin extends Moedas implements Tarifacao{
    private static final double taxaCompra = 0.02;
    private static final double taxaVenda = 0.03;
    
    public Bitcoin(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Bitcoin(){
        
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
