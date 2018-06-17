package test;

import cn.com.yusys.mapper.BranchMapper;
import cn.com.yusys.po.Branch;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.text.normalizer.UBiDiProps;

public class DaoTest {
    @Test
    public void  testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);


        Branch branch = branchMapper.selectByPrimaryKey("1");
        System.out.println(branch.getName());
    }
}
