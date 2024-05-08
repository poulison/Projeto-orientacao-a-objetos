package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Pessoa;

public class PessoaDAO {
    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{
//        String sql = "select * from aluno where usuario = '" + 
//                aluno.getUsuario() + "' AND senha = '" +
//                aluno.getSenha() + "'";
        String sql = "select * from innvestidor where CPF = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCPF());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Pessoa pessoa) throws SQLException{
        String sql = "insert into Pessoa (nome, CPF, senha) values ('" +
                pessoa.getNome() + "', '" + 
                pessoa.getCPF() + "', '" +
                pessoa.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
   
}
