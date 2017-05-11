package com.LWT.DataController;




import com.LWT.Utils.LoginUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lekoxnfx on 2017/3/14.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = req.getSession();

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String destServer = req.getParameter("destserver");
        System.out.println(userName);
        System.out.println(password);
        System.out.println(destServer);
        if(userName.equals("admin")){
            httpSession.setAttribute("username",userName);
            httpSession.setAttribute("password",password);
            LoginUtils.setDestserver(destServer);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
        else {
            PrintWriter out=resp.getWriter();
            out.println("<script>alert('用户名或密码输入错误！')</script>");
        }

    }
}
