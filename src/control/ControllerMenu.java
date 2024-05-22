
package control;


import DAO.Conexao;
import DAO.CotaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Menu;

/**
 *
 * @author Paulo
 */
public class ControllerMenu {
    private Menu view;
    private Investidor investidor; 
    
    public ControllerMenu(Menu view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
    public void cria(Investidor investidor){
       Conexao conexao = new Conexao();
     
        try{
            Connection conn = conexao.getConnection();
            CotaDAO dao = new CotaDAO(conn);
            dao.gerar(investidor);
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro!");
        }
   } 
    
    
}
