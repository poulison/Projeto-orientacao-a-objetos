
package model;

/**
 *
 * @author Paulo
 */
public class Real extends Moedas implements Tarifacao{
    
    public Real(double saldo, double cotas){
        super(saldo, cotas);
    }
    
    public Real(){
        
    }

    @Override
    public double getTaxaCompra() {
        return 0.0;
    }

    @Override
    public double getTaxaVenda() {
        return 0.0;
    }
    
}
