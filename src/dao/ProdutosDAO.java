/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author soare
 */
public class ProdutosDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProdutosDAO() {
                    this.conexao = new Conexao();
                    this.conn = this.conexao.getConexao();
                }
    
        public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                            + "(?, ?, ?)";
                    try {
                        PreparedStatement stmt = this.conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setInt(2, produto.getValor());
                        stmt.setString(3, produto.getStatus());
                        stmt.execute();
            
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
    }
        
                public List<ProdutosDTO> listarProdutos() {
                String sql = "SELECT * FROM produtos";
                
                try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();            
                    
                    List<ProdutosDTO> listaProduto = new ArrayList<>();
                    
                    while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                        ProdutosDTO produtos = new ProdutosDTO();
                        
                        produtos.setId(rs.getInt("id"));
                        produtos.setNome(rs.getString("nome"));
                        produtos.setValor(rs.getInt("valor"));
                        produtos.setStatus(rs.getString("status"));
                        
                        listaProduto.add(produtos);    
                    }
                    return listaProduto;
                } catch (Exception e) {
                    return null;
                }
            }
}
