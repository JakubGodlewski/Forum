package servlets;

import classes.Topic;
import classes.User;
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
@WebServlet("/newtopic")
public class NewTopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if(!"".equals(title) && !"".equals(content))
        {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            User logged = (User)request.getSession().getAttribute("user");
            TopicsDAO topicsDAO = (TopicsDAO)request.getAttribute("topicsDAO");
            Topic topic = new Topic();
            topic.setDateTopic(timestamp);
            topic.setContent(content);
            topic.setTitle(title);
            topic.setUser(logged);
            if(topicsDAO.insertTopic(topic))
            {
                response.sendRedirect(request.getContextPath()+"/topic?id="+topic.getId());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/newtopic.jsp").forward(request, response);
    }
}
