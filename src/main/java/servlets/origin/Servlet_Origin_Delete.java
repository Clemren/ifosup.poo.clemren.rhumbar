package servlets.origin;

import dao.OriginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Origin_Delete", urlPatterns = {"/origin/delete"})
public class Servlet_Origin_Delete extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var originDao = new OriginDao();
        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
                originDao.delete(id);
            }
            catch (Exception e){

            }
        }
        response.sendRedirect(request.getContextPath() + "/origin");
    }
}
