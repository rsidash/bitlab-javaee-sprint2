package kz.bitlab.academy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.academy.entity.User;
import kz.bitlab.academy.service.UserService;

import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = UserService.findByEmailAndPassword(email, password);

        if (nonNull(user)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }

        resp.sendRedirect("/login?loginFailed");
    }
}
