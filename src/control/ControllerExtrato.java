
package control;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.ConsultarExtrato;
import view.Menu;

/**
 *
 * @author Paulo
 */
public class ControllerExtrato {
    private ConsultarExtrato view;
    private Investidor investidor;
    
    public ControllerExtrato(ConsultarExtrato view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;   
    }
    
    public void exibirExtrato(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            int maior_id = dao.maiorId();
            for(int id = 1; id <= maior_id; id++){
                ResultSet res = dao.consultaExtrato(investidor, id);
                if(res.next()){
                    String nome = res.getString("nome");
                    String cpf = res.getString("cpf");
                    double valor = res.getDouble("valor");
                    String data = res.getString("data");
                    String hora = res.getString("hora");
                    double saldo_re = res.getDouble("saldo_re");
                    double saldo_bit = res.getDouble("saldo_bit");
                    double saldo_et = res.getDouble("saldo_et");
                    double saldo_rip = res.getDouble("saldo_rip");
                    double taxa = res.getDouble("taxa");
                    String tipo = res.getString("tipo");
                    double cota = res.getDouble("cota");
                    String textoAnterior = view.getExtratotxt().getText();
                    String operacao = "NOME: " + nome + " CPF:" + cpf + " | " + 
                            data + "  " + hora + " | " + tipo + " " + valor + 
                            " | COTAÇÃO: " + cota + "  TAXA: " + taxa + 
                            " | REAL: " + saldo_re + "  BITCOIN: " + saldo_bit +
                            "  ETHEREUM: " + saldo_et + "  RIPPLE: " + saldo_rip + "\n";
                    view.getExtratotxt().setText(textoAnterior + "\n" + operacao);
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
}

