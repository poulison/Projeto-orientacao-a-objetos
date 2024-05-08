
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import model.Investidor;
import view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCPF().gettext(), 
                                      view.getTxtsenha().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
