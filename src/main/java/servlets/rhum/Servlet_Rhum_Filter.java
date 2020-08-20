package servlets.rhum;

import dao.RhumDao;
import filters.RhumFilter;
import managers.RhumManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_Rhum_Filter", urlPatterns = {"/rhum/filter"})
public class Servlet_Rhum_Filter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        var rhumManager = new RhumManager();
        var rhumDao = new RhumDao();

        var nameParameter = request.getParameter("name") != null ? request.getParameter("name") : "" ;;
        var trademarkParameter = request.getParameter("trademark") != null ? request.getParameter("trademark") : "" ;
        var origineParameter = request.getParameter("origin") != null ? request.getParameter("origin") : "";
        var countryIdParameter = request.getParameter("countryId");
        Integer countryId = 0;
        if (countryIdParameter != null) {
            try {
                countryId = Integer.parseInt(countryIdParameter);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        var filter = new RhumFilter(nameParameter, trademarkParameter, origineParameter, countryId);
        var rhums = rhumManager.getRhumSearch(filter,rhumDao.findAll());
        request.setAttribute("rhums", rhums);
        request.getRequestDispatcher("/views/rhum/table.jsp").forward(request, response);

        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");

    }
}
