package servlets;

import classes.User;
import dao.UsersDAO;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakub on 15.06.2017.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if(login!=null && password!= null && password2!=null && password.equals(password2) && !"".equals(password))
        {
            UsersDAO usersDAO = (UsersDAO)request.getAttribute("usersDAO");
            try
            {
                usersDAO.getUserByLogin(login);
                request.setAttribute("error", "Login exists in database");
                doGet(request, response);
                return;
            }
            catch(NoResultException e)
            {
                User newUser = new User();
                newUser.setLogin(login);
                newUser.setPassword(password);
                if(usersDAO.insertUser(newUser))
                {
                    response.sendRedirect(request.getContextPath()+"/index");
                }
                else
                {
                    request.setAttribute("error", "Creating new user wasn't successful");
                }
                e.printStackTrace();
            }
        }
        else
        {
            request.setAttribute("error", "Registration data error");
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/registration.jsp").forward(request, response);
    }
}
