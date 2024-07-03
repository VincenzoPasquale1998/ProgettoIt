package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.Partita;

public class PartitaDAO {
    private Connection connection;

    public PartitaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createPartita(Date data, String luogo) throws SQLException {
        String query = "INSERT INTO Partita (data, luogo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, data);
            stmt.setString(2, luogo);
            stmt.executeUpdate();
        }
    }

    public List<Partita> readPartite() throws SQLException {
        List<Partita> partite = new ArrayList<>();
        String query = "SELECT * FROM Partita";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Partita partita = new Partita();
                partita.setId(rs.getInt("id"));
                partita.setData(rs.getDate("data"));
                partita.setLuogo(rs.getString("luogo"));
                partite.add(partita);
            }
        }
        return partite;
    }

    public void updatePartita(int id, Date data, String luogo) throws SQLException {
        String query = "UPDATE Partita SET data = ?, luogo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, data);
            stmt.setString(2, luogo);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void deletePartita(int id) throws SQLException {
        String query = "DELETE FROM Partita WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
