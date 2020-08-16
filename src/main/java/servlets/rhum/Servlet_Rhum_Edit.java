package servlets.rhum;

import beans.Rhum;
import beans.Trademark;
import dao.RhumDao;
import dao.TrademarkDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Rhum_Edit", urlPatterns = {"/rhum/edit"})
public class Servlet_Rhum_Edit extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var rhumDao = new RhumDao();
        request.setCharacterEncoding("UTF-8");
        var idParameter = request.getParameter("id");
        var nameParameter = request.getParameter("name");
        var fkTrademarkParameter = request.getParameter("fk_trademark");
        Integer id = null;
        Integer fk_trademark = null;
        if (idParameter != null){
            try{
                id = Integer.parseInt(idParameter);
                fk_trademark= Integer.parseInt(fkTrademarkParameter);
            }
            catch (Exception e){

            }
        }
        var rhum = new Rhum(id, fk_trademark ,nameParameter);
        if (id != 0) {
            rhumDao.update(rhum);
        }
        else{
            rhumDao.create(rhum);
        }
        response.sendRedirect(request.getContextPath() + "/rhum");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var rhumDao = new RhumDao();
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
        var rhum = new Rhum();
        if (id != null){
            rhum = rhumDao.find(id);

        }
        var trademarks = trademarkDao.findAll();
        request.setAttribute("rhum", rhum);
        request.setAttribute("trademarks", trademarks);
        request.getRequestDispatcher("/views/rhum/edit.jsp").forward(request, response);
    }


}
