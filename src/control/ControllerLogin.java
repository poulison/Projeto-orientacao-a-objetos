
package control;

import DAO.PessoaDAO;
import DAO.Conexao;
import view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Pessoa;
import view.Menu;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void LoginInvestidor(){
        Pessoa pessoa = new Pessoa(null, view.getTxtCPF().getText(), 
                                      view.getTxtsenha().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                Menu m = new Menu();
                m.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
