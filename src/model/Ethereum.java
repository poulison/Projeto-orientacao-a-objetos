
package model;

/**
 *
 * @author Paulo
 */
public class Ethereum extends Moedas implements Tarifacao{
    private static final double taxaCompra = 0.01;
    private static final double taxaVenda = 0.02;
    
    public Ethereum(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Ethereum(){
        
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
