

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
        System.out.println(statement);
        ResultSet resultado = statement.getResultSet();
        System.out.println(resultado);
        return resultado;
        
    }
    
    public void inserir(Investidor investidor) throws SQLException{
        String sql = "INSERT INTO public.investidor(\n" +
        "nome, cpf, senha, saldo_real, saldo_btc, saldo_eth, saldo_ripple)" +
        "VALUES (?, ?, ?, 0.0, 0.0, 0.0, 0.0);";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCPF());
        statement.setString(3, investidor.getSenha());
        statement.execute();
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
    
    
        
    
    
    
   

