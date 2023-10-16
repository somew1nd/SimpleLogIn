package com.login;

import com.login.mapper.get_client;
import com.login.mapper.update_client;
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

@WebServlet("/reg")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String username = parameterMap.get("username")[0];
        String password = parameterMap.get("password")[0];
        SqlSessionFactory sqlSessionFactory = SqlsessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        update_client mapper_re = sqlSession.getMapper(update_client.class);
        get_client mapper_ve = sqlSession.getMapper(get_client.class);
        client byName = mapper_ve.get_by_name(username);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (byName == null){
            mapper_re.update_client(username,password);
            sqlSession.commit();
            writer.write("成功");
        }else{
            writer.write("用户名已存在");
        }
    }
}
