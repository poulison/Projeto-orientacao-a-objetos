/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Moedas;
/**
 *
 * @author Paulo
 */
public class CotaDAO {
    private Connection conn;
    ArrayList<Moedas> moedas = new ArrayList<Moedas>();
    
    public CotaDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet consultar() {
    try {
        String sql = "SELECT * FROM moedas WHERE id = (SELECT MAX(id) FROM moedas)";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        return resultado;
    } catch (SQLException e) {
        return null; 
    }




    }
}



