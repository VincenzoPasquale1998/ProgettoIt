package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.Squadra;
import util.DatabaseManager;

public class SquadraDAO {
    private Connection connection;

    public SquadraDAO(Connection connection) {
        this.connection = connection;
    }

    public void createSquadra(String nome, String citta) throws SQLException {
        String query = "INSERT INTO Squadra (nome, citta) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, citta);
            stmt.executeUpdate();
        }
    }

    public List<Squadra> readSquadre() throws SQLException {
        List<Squadra> squadre = new ArrayList<>();
        String query = "SELECT * FROM Squadra";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Squadra squadra = new Squadra();
                squadra.setId(rs.getInt("id"));
                squadra.setNome(rs.getString("nome"));
                squadra.setCitta(rs.getString("citta"));
                squadre.add(squadra);
            }
        }
        return squadre;
    }

    public void updateSquadra(int id, String nome, String citta) throws SQLException {
        String query = "UPDATE Squadra SET nome = ?, citta = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, citta);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void deleteSquadra(int id) throws SQLException {
        String query = "DELETE FROM Squadra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
