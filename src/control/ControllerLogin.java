
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;

import view.Menu;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void LoginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCPF().getText(), 
                                      view.getTxtsenha().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String CPF = res.getString("cpf");
                String senha = res.getString("senha");
                Menu m = new Menu(new Investidor(nome,CPF,senha));
                m.setVisible(true);
                
                
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
