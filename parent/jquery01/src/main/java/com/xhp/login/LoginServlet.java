package com.xhp.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xhp on 2016/9/26.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        User user = new User();
        user.setPassword(passwd);
        user.setName(name);
        if("jack".equals(name) && "1234".equals(passwd)){
            request.getSession().setAttribute("user",user);
            response.getWriter().print("登陆成功");
        }else
            response.getWriter().print("用户名或密码有误");
        response.getWriter().flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
