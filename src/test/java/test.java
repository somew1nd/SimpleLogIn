import com.login.SqlsessionUtil;
import com.login.mapper.get_client;
import com.login.pojo.client;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;


public class test {
    @Test
    public void testSql(){
        SqlSessionFactory sqlSessionFactory = SqlsessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        get_client mapper = sqlSession.getMapper(get_client.class);
        client client = mapper.get_by_NameAndPassword("zhangsan", "123");
        System.out.println(client);
    }
}
