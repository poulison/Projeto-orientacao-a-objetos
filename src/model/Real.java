
package model;

/**
 *
 * @author Paulo
 */
public class Real extends Moedas implements Tarifacao{
    private static final double taxaCompra = 0.0;
    private static final double taxaVenda = 0.0;
    
    public Real(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Real(){
        
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
