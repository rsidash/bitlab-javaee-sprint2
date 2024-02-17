package kz.bitlab.academy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.academy.service.ItemService;

import java.io.IOException;

@WebServlet("/top10")
public class Top10Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", ItemService.findTop10());
        req.getRequestDispatcher("/top10.jsp").forward(req, resp);
    }

}