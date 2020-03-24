import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class testAop {

    BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_aop.xml");
    ProductService service = (ProductService) factory.getBean("productServiceImpl");
    @Test
    public void testInsert(){
        Product product =  new Product();
        product.setProId("74838ewyhsuwq666666");
        product.setProName("小米电视14");
        product.setProNum(777777L);
        product.setProSize(43f);
        product.setProColor("黑色");
        product.setProPrice(8999f);
        product.setProAddress("苏州");
        product.setProDate(new Date());

        service.add(product);
    }
    @Test
    public void testaop(){
      Product p1= service.getById("298c495f21124c6889de8145731fad07");
      Product p2=service.getById("2c62d63a19c8471b95df9218524a0080");

        service.updateScore(p1,p2);
    }


}
