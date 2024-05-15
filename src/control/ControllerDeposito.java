
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;
import view.Depositar;


public class ControllerDeposito {
    private Depositar view;

    public ControllerDeposito(Depositar view) {
        this.view = view;
    }
    
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
