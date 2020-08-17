package annotation;

import com.jk.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean2.xml")
public class TestDemo1 {
    @Autowired
    AccountService as;


    @Test
    public void testAnnotation() {
        as.transferMoney(1, 2, 100f);
    }
}
