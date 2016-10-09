package com.xhp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xhp on 2016/10/9.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        User user = new User();
        user.setName(name);
        user.setPassword(passwd);
        if("jack".equals(name) && "123".equals(passwd)){
            request.getSession().setAttribute("user",user);
            response.getWriter().print("登陆成功");
        }else{
            response.getWriter().print("用户名或密码有误");
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
