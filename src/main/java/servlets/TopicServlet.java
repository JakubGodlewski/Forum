package servlets;

import classes.Inscription;
import classes.Topic;
import classes.User;
import dao.InscriptionsDAO;
import dao.TopicsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jakub on 15.06.2017.
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String stringId = request.getParameter("id");
        if(content!=null && stringId!=null)
        {
            int id = Integer.parseInt(stringId);
            InscriptionsDAO inscriptionsDAO = (InscriptionsDAO)request.getAttribute("inscriptionsDAO");
            TopicsDAO topicsDAO = (TopicsDAO)request.getAttribute("topicsDAO");
            User logged = (User)request.getSession().getAttribute("user");
            Topic topic = topicsDAO.selectTopicById(id);
            Inscription inscription = new Inscription();
            inscription.setDate(new Timestamp(new Date().getTime()));
            inscription.setContent(content);
            inscription.setUser(logged);
            inscription.setTopic(topic);
            inscriptionsDAO.insertInscription(inscription);
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringId = request.getParameter("id");
        if(stringId!=null)
        {
            int id = Integer.parseInt(stringId);
            TopicsDAO topicsDAO = (TopicsDAO)request.getAttribute("topicsDAO");
            Topic topic = topicsDAO.selectTopicById(id);
            request.setAttribute("topic", topic);
            request.getRequestDispatcher("/view/topic.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
