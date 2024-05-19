/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Paulo
 */
public class Investidor extends Pessoa {
    private Carteira carteira;
    
    public Investidor(Carteira carteira, String nome, String CPF, String senha) {
        super(nome, CPF, senha);
        this.carteira = carteira;
    }
    
    public Investidor(String nome, String CPF, String senha) {
        this(null, nome, CPF, senha);
        this.carteira = new Carteira();
    }
    
    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    
    
    
    @Override
    public String toString() {
        return "Investidor{" + "carteira=" + carteira + '}';
    }
    
    
}
