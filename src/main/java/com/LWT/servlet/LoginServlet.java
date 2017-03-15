package com.LWT.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lekoxnfx on 2017/3/14.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String destServer = req.getParameter("destserver");
        if(userName.equals("admin")){
            httpSession.setAttribute("username",userName);
            httpSession.setAttribute("password",password);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
        else {
            resp.sendRedirect("/login.jsp");
        }

    }
}
