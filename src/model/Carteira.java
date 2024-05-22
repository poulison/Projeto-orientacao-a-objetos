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
        moedas.add(new Bitcoin(0, 0.0000029));
        moedas.add(new Ethereum(0, 0.000064));
        moedas.add(new Bitcoin(0, 0.38));
         
    }
    
    
    public Carteira(ArrayList<Moedas> moedas){
        this.moedas = moedas;
    }
    
    public ArrayList<Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }

    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + '}';
    }
}
