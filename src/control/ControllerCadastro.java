
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import view.Cadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;


public class ControllerCadastro {
    private Cadastro view;

    public ControllerCadastro(Cadastro view) {
        this.view = view;
    }
    
       public void salvarPessoa(){  
        String nome = view.getTxtnome().getText();
        String CPF = view.getTxtCPF().getText();
        String senha = view.getTxtsenha().getText();
        
        Investidor investidor = new Investidor(nome, CPF, senha);
        Conexao conexao = new Conexao();
        
        try{
           
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.inserir(investidor);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!");
             
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Usuario nao Cadastrado!");
        }
    }
}
