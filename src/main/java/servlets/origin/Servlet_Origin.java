package servlets.origin;

import dao.OriginDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Origin", urlPatterns = {"/origin"})
public class Servlet_Origin extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        var originDao = new OriginDao();
        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
            }
            catch (Exception e){

            }
        }

        var contextPath = request.getServletContext().getContextPath();

        var origins = originDao.findAll();
        request.setAttribute("origins", origins);
        request.getRequestDispatcher("views/origin/origin.jsp").forward(request, response);
    }


}
