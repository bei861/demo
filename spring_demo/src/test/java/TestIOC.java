import com.aistar.dao.ProductDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void getDaoBean(){
        //1.实例化SPring容器
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获得容器中的bean对象
        ProductDao dao = (ProductDao)factory.getBean("productDao");
        dao.selectAll();
    }
}
