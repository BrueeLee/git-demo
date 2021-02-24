package cn.learn.test;

import cn.learn.pojo.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test1 {
    /**
     * 测试jpa的保存
     */
    @Test
    public void testSave(){
        //加载配置文件创建工厂(实体管理器工厂) 对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Customer customer=new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        em.persist(customer);
        transaction.commit();
        em.clear();
        factory.close();
    }
}
