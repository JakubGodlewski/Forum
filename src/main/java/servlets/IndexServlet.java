package servlets;

import classes.Inscription;
import classes.Topic;
import dao.InscriptionsDAO;
import dao.TopicsDAO;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jakub on 15.06.2017.
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TopicsDAO topicsDAO = (TopicsDAO)request.getAttribute("topicsDAO");
        List<Topic> topics = topicsDAO.selectTopics();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
