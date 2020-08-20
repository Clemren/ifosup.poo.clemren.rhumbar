package servlets.origin;

import beans.Country;
import beans.Origin;
import dao.CountryDao;
import dao.OriginDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Origin_Edit", urlPatterns = {"/origin/edit"})
public class Servlet_Origin_Edit extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var originDao = new OriginDao();
        var countryDao = new CountryDao();
        request.setCharacterEncoding("UTF-8");
        var idParameter = request.getParameter("id");
        var nameParameter = request.getParameter("name");
        var countryAlpha2Parameter = request.getParameter("country");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
            }
            catch (Exception e){

            }
        }
        var origin = new Origin(id, nameParameter);
        origin.setFk_countryAlpha2(countryDao.findByAlpha2(countryAlpha2Parameter).getPk());
        if (id != 0) {
            originDao.update(origin);
        }
        else{
            originDao.create(origin);
        }
        response.sendRedirect(request.getContextPath() + "/origin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        var origin = new Origin();
        if (id != null){
            origin = originDao.find(id);

        }
        request.setAttribute("origin", origin);
        request.getRequestDispatcher("/views/origin/edit.jsp").forward(request, response);
    }


}
