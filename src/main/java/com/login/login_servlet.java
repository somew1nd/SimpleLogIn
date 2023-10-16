package com.login;

import com.login.mapper.get_client;
import com.login.pojo.client;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/login")
public class login_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("error method");
        System.out.println("login method error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String Username = parameterMap.get("username")[0];
        String Password = parameterMap.get("password")[0];
        SqlSessionFactory sqlSessionFactory = SqlsessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        get_client mapper = sqlSession.getMapper(get_client.class);
        client client = mapper.get_by_NameAndPassword(Username, Password);
        System.out.println(Username);
        System.out.println(Password);
        System.out.println(client);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (client != null) {
            writer.write("登录成功");
        } else {
            writer.write("登录失败");
        }


    }
}
