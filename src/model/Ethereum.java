
package model;

/**
 *
 * @author Paulo
 */
public class Ethereum extends Moedas implements Tarifacao{
    
    public Ethereum(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Ethereum(){
        
    }
    
    @Override
    public double getTaxaCompra() {
        return 0.01;
    }

    @Override
    public double getTaxaVenda() {
        return 0.02;
    }
}
