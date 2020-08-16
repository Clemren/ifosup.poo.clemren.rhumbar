package servlets.trademark;

import dao.OriginDao;
import dao.TrademarkDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Trademark_Delete", urlPatterns = {"/trademark/delete"})
public class Servlet_Trademark_Delete extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var trademarkDao = new TrademarkDao();
        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
                trademarkDao.delete(id);
            }
            catch (Exception e){

            }
        }
        response.sendRedirect(request.getContextPath() + "/trademark");
    }
}
