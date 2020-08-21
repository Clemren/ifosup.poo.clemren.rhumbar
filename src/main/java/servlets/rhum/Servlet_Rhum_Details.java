package servlets.rhum;

import beans.Rhum;
import dao.CountryDao;
import dao.RhumDao;
import filters.RhumFilter;
import managers.RhumManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Rhum_Details", urlPatterns = {"/rhum/details"})
public class Servlet_Rhum_Details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var rhumDao = new RhumDao();
        Rhum rhum = null;
        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
                rhum = rhumDao.find(id);
            }
            catch (Exception e){

            }
        }
        request.setAttribute("rhum", rhum);
        request.getRequestDispatcher("/views/rhum/details.jsp").forward(request, response);

        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");

    }
}
