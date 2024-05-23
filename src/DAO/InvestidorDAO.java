

package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import model.Bitcoin;
import model.Investidor;
import model.Moedas;
import model.Carteira;
import model.Ethereum;
import model.Real;
import model.Ripple;



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
    
    public void geraExtratodep(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas realItem = investidor.getCarteira().getMoedas().get(0);
        Real real = (Real) realItem;
        double taxaCompra = real.getTaxaCompra();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaCompra);
            statement.setString(12, "+");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(0).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratosac(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas realItem = investidor.getCarteira().getMoedas().get(0);
        Real real = (Real) realItem;
        double taxaCompra = real.getTaxaCompra();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaCompra);
            statement.setString(12, "-");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(0).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratobitC(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas bitItem = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitItem;
        double taxaCompra = bitcoin.getTaxaCompra();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaCompra);
            statement.setString(12, "+");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(1).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratobitV(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas bitItem = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitItem;
        double taxaVenda = bitcoin.getTaxaVenda();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaVenda);
            statement.setString(12, "-");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(1).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratoethC(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas ethItem = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethItem;
        double taxaCompra = ethereum.getTaxaCompra();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaCompra);
            statement.setString(12, "+");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(2).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratoethV(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas ethItem = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethItem;
        double taxaVenda = ethereum.getTaxaVenda();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaVenda);
            statement.setString(12, "-");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(2).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratoripC(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas ripItem = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) ripItem;
        double taxaCompra = ripple.getTaxaCompra();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaCompra);
            statement.setString(12, "+");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(3).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public void geraExtratoripV(Investidor investidor, double valor) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
        int maiorId = 0;
        if (resultSet.next()) {
            maiorId = resultSet.getInt(1);
        }
        
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(data);

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = hora.format(formatter);
        
        Moedas ripItem = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) ripItem;
        double taxaVenda = ripple.getTaxaVenda();
        
        int id_e = maiorId + 1;
        String sql = "INSERT INTO extrato(\n" +
        "id_e, nome, cpf, valor, data, hora, saldo_re, saldo_bit, saldo_et, "
         + "saldo_rip, taxa, tipo, cota )" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
        PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_e);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCPF());
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(9, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(10, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(11, taxaVenda);
            statement.setString(12, "-");
            statement.setDouble(13, investidor.getCarteira().getMoedas().get(3).getCotas());
            
            statement.executeUpdate();
        
 
        }
    
    public int maiorId() {
        int id = 0;
        try {
            if (conn != null) {
                ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_e) FROM extrato");
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public ResultSet consultaExtrato(Investidor investidor, double id) throws SQLException{
        
        String sql = "select * from extrato where cpf = ? and id_e = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCPF());
        statement.setDouble(2, id);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
    }
    
    
}
    
    
        
    
    
    
   

