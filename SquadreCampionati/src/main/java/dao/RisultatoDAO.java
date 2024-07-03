package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.Risultato;

public class RisultatoDAO {
    private Connection connection;

    public RisultatoDAO(Connection connection) {
        this.connection = connection;
    }

    public void createRisultato(int golSegnati, int squadraId, int partitaId) throws SQLException {
        String query = "INSERT INTO Risultato (gol_segnati, squadra_id, partita_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, golSegnati);
            stmt.setInt(2, squadraId);
            stmt.setInt(3, partitaId);
            stmt.executeUpdate();
        }
    }

    public List<Risultato> readRisultati() throws SQLException {
        List<Risultato> risultati = new ArrayList<>();
        String query = "SELECT * FROM Risultato";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Risultato risultato = new Risultato();
                risultato.setId(rs.getInt("id"));
                risultato.setGolSegnati(rs.getInt("gol_segnati"));
                risultato.setSquadraId(rs.getInt("squadra_id"));
                risultato.setPartitaId(rs.getInt("partita_id"));
                risultati.add(risultato);
            }
        }
        return risultati;
    }

    public void updateRisultato(int id, int golSegnati, int squadraId, int partitaId) throws SQLException {
        String query = "UPDATE Risultato SET gol_segnati = ?, squadra_id = ?, partita_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, golSegnati);
            stmt.setInt(2, squadraId);
            stmt.setInt(3, partitaId);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deleteRisultato(int id) throws SQLException {
        String query = "DELETE FROM Risultato WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
