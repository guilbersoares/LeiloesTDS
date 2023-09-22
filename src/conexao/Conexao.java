/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author soare
 */
public class Conexao {
    public Connection getConexao(){
       try {
            Connection conn; 
            Statement st; 
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root","99567283"); 
            System.out.println("Sucesso!");
            st = conn.createStatement();
            return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("O Driver não está disponível na biblioteca!");
            return null;
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida!");
            return null;
        }
    }
}
