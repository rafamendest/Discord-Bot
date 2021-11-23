package discordbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDAO {

    private Connection conn;
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    
    public boolean conectaBD() {

        try {
            String url = "jdbc:sqlite:banco_sqlite.db";
            this.setConn(DriverManager.getConnection(url)); 
            
        } catch (SQLException erro) {
            System.out.println("Erro na conexão");
            return false;
        }
      return true;
    }

    

}
