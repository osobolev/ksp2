package ru.mirea.ksp.example2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(
            "<html><body>" +
            "  <form method='post' action='reply.html'>" +
            "  Как тебя зовут? <input name='user_name'> <input type='submit'>" +
            "  </form>" +
            "</body></html>"
        );
    }
}
