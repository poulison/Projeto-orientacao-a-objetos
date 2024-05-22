

package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
import model.Investidor;
import model.Moedas;
import model.Carteira;



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
    public void atualizarB (Investidor investidor) throws SQLException{
        
        String sql = "update investidor set saldo_btc = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setString(2,investidor.getCPF());
        statement.executeUpdate();
        statement.close();
        
    }
    public void atualizarE (Investidor investidor) throws SQLException{
        
        String sql = "update investidor set saldo_eth = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setString(2,investidor.getCPF());
        statement.executeUpdate();
        statement.close();
        
    }
    public void atualizarR (Investidor investidor) throws SQLException{
        
        String sql = "update investidor set saldo_ripple = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(2,investidor.getCPF());
        statement.executeUpdate();
        statement.close();
        
    }
    
    public void atualizarC(Investidor investidor) throws SQLException{
        String sql = "update moedas set bitcoin = ?, ethereum = ?, ripple = ?";
        double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotas();
        double cotacaoEth = investidor.getCarteira().getMoedas().get(2).getCotas();
        double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotas();
        PreparedStatement statement = conn.prepareStatement(sql);
        Random random = new Random();
        double variacaoBit = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        double variacaoEth = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        double variacaoRip = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        
        double cotacaoBitAtualizada = cotacaoBit * (1 + variacaoBit);
        double cotacaoEthAtualizada = cotacaoEth * (1 + variacaoEth);
        double cotacaoRipAtualizada = cotacaoRip * (1 + variacaoRip);
        
        investidor.getCarteira().getMoedas().get(1).setCotas(cotacaoBitAtualizada);
        investidor.getCarteira().getMoedas().get(2).setCotas(cotacaoEthAtualizada);
        investidor.getCarteira().getMoedas().get(3).setCotas(cotacaoRipAtualizada);
        
        statement.setDouble(1, cotacaoBitAtualizada);
        statement.setDouble(2, cotacaoEthAtualizada);
        statement.setDouble(3, cotacaoRipAtualizada);
        statement.execute();
        conn.close();
    }
    
    
}
    
    
        
    
    
    
   

