package filters;

import classes.User;
import dao.UsersDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakub on 15.06.2017.
 */
@WebFilter("/*")
public class LoggedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request  = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        request.setCharacterEncoding("UTF-8");
        String login = request.getRemoteUser();
        if(login!=null)
        {
            User user = (User)request.getSession().getAttribute("user");
            if(user==null)
            {
                UsersDAO usersDAO = (UsersDAO)request.getAttribute("usersDAO");
                user = usersDAO.getUserByLogin(login);
                request.getSession().setAttribute("user", user);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
