/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leiloestds;

import conexao.Conexao;
import forms.cadastroVIEW;

/**
 *
 * @author soareg
 */
public class LeiloesTDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             Conexao c = new Conexao();
      c.getConexao();
      
      cadastroVIEW telaPrincipal = new cadastroVIEW();
      telaPrincipal.setVisible(true);
    }
    
}
