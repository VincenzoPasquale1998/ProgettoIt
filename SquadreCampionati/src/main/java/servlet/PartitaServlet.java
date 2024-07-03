package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import bean.Partita;
import dao.PartitaDAO;
import util.DatabaseManager;

//@WebServlet("/PartitaServlet")
public class PartitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PartitaDAO partitaDAO;

    public void init() throws ServletException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            partitaDAO = new PartitaDAO(dbManager.getConnection());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Partita> partite = partitaDAO.readPartite();
            request.setAttribute("partite", partite);
            request.getRequestDispatcher("partita.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date data = Date.valueOf(request.getParameter("data"));
        String luogo = request.getParameter("luogo");
        try {
            partitaDAO.createPartita(data, luogo);
            response.sendRedirect("PartitaServlet");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
