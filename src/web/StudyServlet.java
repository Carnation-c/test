package web;

import service.SportService;
import service.StudyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studyServlet")
public class StudyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = (String) request.getSession().getAttribute("username");
        String studyID = request.getParameter("study");
        String study = "";
        if (studyID.equals("4")){
            study = "学习";
        }else if (studyID.equals("5")){
            study = "自习";
        }else if (studyID.equals("6")){
            study = "辅导";
        }
        StudyService studyService = new StudyService();
        boolean studySuccess = studyService.studyAppointment(username, study);
        response.setCharacterEncoding("utf-8");
        if (studySuccess){
            response.sendRedirect(request.getContextPath()+"/InterFace/successAppo.html");
        }else{
            response.getWriter().write("预约失败，请稍后尝试");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
