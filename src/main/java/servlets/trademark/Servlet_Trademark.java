package servlets.trademark;

import dao.OriginDao;
import dao.TrademarkDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Trademark", urlPatterns = {"/trademark"})
public class Servlet_Trademark extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var trademarkDao = new TrademarkDao();
        var idParameter = request.getParameter("id");
        Integer id = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
            }
            catch (Exception e){

            }
        }
        var trademarks = trademarkDao.findAll();

        request.setAttribute("trademarks", trademarks);

        request.getRequestDispatcher("views/trademark/trademark.jsp").forward(request, response);
    }


}
