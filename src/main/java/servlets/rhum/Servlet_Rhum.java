package servlets.rhum;

import beans.Trademark;
import dao.OriginDao;
import dao.RhumDao;
import dao.TrademarkDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Rhum", urlPatterns = {"/rhum"})
public class Servlet_Rhum extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var rhumDao = new RhumDao();

        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
            }
            catch (Exception e){

            }
        }
        var rhums = rhumDao.findAll();
        request.setAttribute("rhums", rhums);
        request.getRequestDispatcher("views/rhum/rhum.jsp").forward(request, response);
    }


}
