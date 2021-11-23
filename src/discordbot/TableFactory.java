/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author RafaelMT
 */
public class TableFactory {

    private final ConexaoDAO conn2;

    public TableFactory(ConexaoDAO p) {
        this.conn2 = p;
    }

    
    
    public void criarTabelaCampeao() {
        
        String url = "CREATE TABLE IF NOT EXISTS tbl_counter"
                    + "("                          
                    + "nome TEXT,"
                    + "res TEXT"
                    + ");";
        boolean conectou = false;
        //executando o sql de criar tabelas
        try {
            conectou = this.conn2.conectaBD();
            Statement stmt = conn2.getConn().createStatement();
            stmt.execute(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro2: " + e);
        }

    }

}
