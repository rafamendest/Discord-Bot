/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RafaelMT
 */
public class ChampionRepository {

    private final ConexaoDAO conn;

    public ChampionRepository(ConexaoDAO p) {
        this.conn = p;
    }

    //Método de buscar resposta de um campeão
    public String buscaChampion(String n) {
        String resposta = "";
        try {
            String url = "SELECT RES FROM tbl_counter WHERE nome = '" + n + "'";

            PreparedStatement ps = conn.getConn().prepareStatement(url);
            ResultSet resultSet = ps.executeQuery();
            resposta = resultSet.getString("res");
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro na busca do campeão");
        }
        return resposta;

    }

    //Método de adicionar um campeão
    public void inserirRegistroChampion(String n, String p) {
        try {
            String url = "INSERT INTO tbl_counter ("
                    + "nome,"
                    + "res"
                    + ") VALUES(?,?);";

            PreparedStatement ps = conn.getConn().prepareStatement(url);
            ps.setString(1, n);
            ps.setString(2, p);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro na criação do campeão");
        }

    }

    //Método de deletar campeão
    public void deletarRegistroChampion(String n) {
        try {
            String url = "DELETE FROM tbl_counter WHERE nome = ?";

            PreparedStatement ps = conn.getConn().prepareStatement(url);
            ps.setString(1, n);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar campeão");
        }

    }

    //Método de alterar registro do campeão
    public void alterarRegistroChampion(String n, String m) {
        try {

            String url = "UPDATE tbl_counter SET res = ? WHERE nome = ?";
            PreparedStatement ps = conn.getConn().prepareStatement(url);
            ps.setString(1, m);
            ps.setString(2, n);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar campeão " + e);
        }

    }

}
