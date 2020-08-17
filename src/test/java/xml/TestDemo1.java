package xml;

import com.jk.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestDemo1 {

    @Autowired
    AccountService as;

    //测试转账
    @Test
    public void testTransfer() {
        as.transferMoney(1, 2, 100f);
    }
}
