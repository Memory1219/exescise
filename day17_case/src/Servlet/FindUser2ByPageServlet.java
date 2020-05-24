package Servlet;

import Service.UserService;
import Service.impl.UserServiceimpl;
import domain.PageBean;
import domain.User2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userListServlet")
public class FindUser2ByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage==null||"".equals(currentPage)){
            currentPage = "1";
        }
        if (rows==null||"".equals(rows)){
            rows = "5";
        }
        UserService service = new UserServiceimpl();
        PageBean<User2> pb =  service.findUser2ByPage(currentPage,rows);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
