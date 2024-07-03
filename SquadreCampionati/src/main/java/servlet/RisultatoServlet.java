package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import bean.Risultato;
import dao.RisultatoDAO;
import dao.SquadraDAO;
import dao.PartitaDAO;
import util.DatabaseManager;

//@WebServlet("/RisultatoServlet")
public class RisultatoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RisultatoDAO risultatoDAO;
    private SquadraDAO squadraDAO;
    private PartitaDAO partitaDAO;

    public void init() throws ServletException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            risultatoDAO = new RisultatoDAO(dbManager.getConnection());
            squadraDAO = new SquadraDAO(dbManager.getConnection());
            partitaDAO = new PartitaDAO(dbManager.getConnection());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Risultato> risultati = risultatoDAO.readRisultati();
            request.setAttribute("risultati", risultati);
            request.getRequestDispatcher("risultato.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int golSegnati = Integer.parseInt(request.getParameter("gol_segnati"));
        int squadraId = Integer.parseInt(request.getParameter("squadra_id"));
        int partitaId = Integer.parseInt(request.getParameter("partita_id"));
        try {
            risultatoDAO.createRisultato(golSegnati, squadraId, partitaId);
            response.sendRedirect("RisultatoServlet");
        } catch (SQLException e) {
                    throw new ServletException(e);
        }
     }
    }