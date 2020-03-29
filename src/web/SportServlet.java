package web;

import service.SportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sportServlet")
public class SportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = (String) request.getSession().getAttribute("username");
        String sportID = request.getParameter("sport");
        String sport = "";
        if (sportID.equals("1")){
            sport = "篮球";
        }else if (sportID.equals("2")){
            sport = "足球";
        }else if (sportID.equals("3")){
            sport = "羽毛球";
        }
        SportService sportService = new SportService();
        boolean sportSuccess = sportService.sportAppointment(username,sport);
        response.setCharacterEncoding("utf-8");
        if (sportSuccess){
            response.sendRedirect(request.getContextPath()+"/InterFace/successAppo.html");
        }else{
            response.getWriter().write("预约失败，请稍后尝试");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
