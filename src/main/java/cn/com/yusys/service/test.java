package cn.com.yusys.service;

import cn.com.yusys.mapper.BranchMapper;
import cn.com.yusys.po.Branch;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);

        Branch branch = branchMapper.selectByPrimaryKey("1");
        System.out.println(branch.getLabel());
    }
}
