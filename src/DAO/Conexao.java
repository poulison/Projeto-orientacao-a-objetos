
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Paulo
 */
public class Conexao {

    public Connection getConnection()throws SQLException{
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/projeto", "postgres", "fei");
        return conexao;
    }
    
}
