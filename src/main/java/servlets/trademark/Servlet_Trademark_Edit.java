package servlets.trademark;

import beans.Origin;
import beans.Trademark;
import dao.OriginDao;
import dao.TrademarkDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Trademark_Edit", urlPatterns = {"/trademark/edit"})
public class Servlet_Trademark_Edit extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var trademarkDao = new TrademarkDao();
        request.setCharacterEncoding("UTF-8");
        var idParameter = request.getParameter("id");
        var nameParameter = request.getParameter("name");
        var fkOriginParameter = request.getParameter("fk_origin");
        Integer id = null;
        Integer fk_origin = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
                fk_origin= Integer.parseInt(fkOriginParameter);
            }
            catch (Exception e){

            }
        }
        var trademark = new Trademark(id, fk_origin ,nameParameter);
        if (id != 0) {
            trademarkDao.update(trademark);
        }
        else{
            trademarkDao.create(trademark);
        }
        response.sendRedirect(request.getContextPath() + "/trademark");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var trademarkDao = new TrademarkDao();
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
        var trademark = new Trademark();
        if (id != null){
            trademark = trademarkDao.find(id);

        }
        var origins = originDao.findAll();
        request.setAttribute("origins", origins);
        request.setAttribute("trademark", trademark);
        request.getRequestDispatcher("/views/trademark/edit.jsp").forward(request, response);
    }


}
