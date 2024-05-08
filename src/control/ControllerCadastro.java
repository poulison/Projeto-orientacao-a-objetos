
package control;

import DAO.PessoaDAO;
import DAO.Conexao;
import view.Cadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Pessoa;

public class ControllerCadastro {
    private Cadastro view;

    public ControllerCadastro(Cadastro view) {
        this.view = view;
    }
    
       public void salvarPessoa(){  
        String nome = view.getTxtnome().getText();
        String CPF = view.getTxtCPF().getText();
        String senha = view.getTxtsenha().getText();
        
        Pessoa pessoa = new Pessoa(nome, CPF, senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            dao.inserir(pessoa);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Usuario nao Cadastrado!");
        }
    }
}
