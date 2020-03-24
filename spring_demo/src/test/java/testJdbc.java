import com.aistar.dao.ProductDao;
import com.aistar.dao.impl.ProductDaoImpl;
import com.aistar.pojo.Product;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class testJdbc {

    @Test
    public void testselect(){
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_jdbc.xml");
        ProductDao dao=(ProductDao) factory.getBean("productDaoImpl");
        Product product=dao.selectByPrimaryKey("59dc0ecea72d435b943db4b1adcdf8bf");
         System.out.println(product);
        System.out.println("=====================all=======================");
        List<Product> productList =dao.selectAll();
        for (Product p:productList){
            System.out.println(p);
        }

    }
    @Test
    public void testupdate(){
        Product product = new Product();
        product.setProName("华为电视");
        product.setProDate(new Date());
        product.setProColor("白色");
        product.setProPrice(9999.00f);
        product.setProSize(40f);
        product.setProAddress("苏州");
        product.setProId("0c3d7d53bfa840c9b7d84ee5db7e0af5");
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_jdbc.xml");
        ProductDao dao = (ProductDao) factory.getBean("productDaoImpl");
//        System.out.println(dao.update(product));
        dao.delete(product.getProId());
    }


}
