package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import bean.Squadra;
import dao.SquadraDAO;
import util.DatabaseManager;

//@WebServlet("/SquadraServlet")
public class SquadraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SquadraDAO squadraDAO;

    public void init() throws ServletException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            squadraDAO = new SquadraDAO(dbManager.getConnection());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Squadra> squadre = squadraDAO.readSquadre();
            request.setAttribute("squadre", squadre);
            request.getRequestDispatcher("squadra.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String citta = request.getParameter("citta");
        try {
            squadraDAO.createSquadra(nome, citta);
            response.sendRedirect("SquadraServlet");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
