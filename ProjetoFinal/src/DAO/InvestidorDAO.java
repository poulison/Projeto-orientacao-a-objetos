package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Investidor;

public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
//        String sql = "select * from aluno where usuario = '" + 
//                aluno.getUsuario() + "' AND senha = '" +
//                aluno.getSenha() + "'";
        String sql = "select * from innvestidor where CPF = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCPF());
        statement.setString(2, Investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Investidor investidor) throws SQLException{
        String sql = "insert into Investidor (nome, CPF, senha) values ('" +
                investidor.getNome() + "', '" + 
                investidor.getCPF() + "', '" +
                investidor.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
   
}
