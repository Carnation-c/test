package web;

import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RegisterService registerService = new RegisterService();
        boolean isRegisterSuccess = registerService.registerUser(username, password);

        response.setCharacterEncoding("utf-8");
        if (isRegisterSuccess){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            response.getWriter().write("注册失败，请稍后再试！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
