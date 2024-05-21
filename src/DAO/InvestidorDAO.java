

package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Investidor;
import model.Moedas;



public class InvestidorDAO {
    private Connection conn;
    ArrayList<Moedas> moedas = new ArrayList<Moedas>();
    
    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }
    
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
        
        String sql = "select * from investidor where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCPF());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
    }
    
    public void inserir(Investidor investidor) throws SQLException{
        String sql = "INSERT INTO investidor(\n" +
        "nome, cpf, senha, saldo_real, saldo_btc, saldo_eth, saldo_ripple)" +
        "VALUES (?, ?, ?, 0.0, 0.0, 0.0, 0.0);";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCPF());
        statement.setString(3, investidor.getSenha());
        String sql1 = "INSERT INTO moedas(\n"+
        "id, bitcoin, ethereum, riple)"+
        "VALUES(1, ?, ?, ?);";
        PreparedStatement statement1 = conn.prepareStatement(sql1);
        statement1.setDouble(1, investidor.getCarteira().getMoedas().get(1).getCotas());
        statement1.setDouble(2, investidor.getCarteira().getMoedas().get(2).getCotas());
        statement1.setDouble(3, investidor.getCarteira().getMoedas().get(3).getCotas());
        statement.execute();
        statement1.execute();
        conn.close();
    }
    
    public ResultSet verificaSenha(Investidor investidor) throws SQLException{
        String sql = "Check * from investidor where cpf = ? and senha = ?";
     
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCPF());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        return statement.executeQuery();
    }
    
    
    public void atualizar (Investidor investidor) throws SQLException{
        
        String sql = "update investidor set saldo_real = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2,investidor.getCPF());
        statement.executeUpdate();
        statement.close();
        
    }
    
    
}
    
    
        
    
    
    
   

