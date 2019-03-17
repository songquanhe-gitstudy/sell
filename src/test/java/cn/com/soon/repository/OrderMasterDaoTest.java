package cn.com.soon.repository;

import cn.com.soon.dao.IOrderMasterDao;
import cn.com.soon.model.OrderMaster;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private IOrderMasterDao orderMasterDao;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("幕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        int insert = orderMasterDao.insert(orderMaster);
        Assert.assertNotNull(insert);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
//        PageRequest request = new PageRequest(1, 3);
        Integer pageNum = 1;
        Integer pageSize = 10;
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNum, pageSize);
        List<OrderMaster> result = orderMasterDao.findAllByBuyerOpenid(OPENID);
//        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

//        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void findAll() {
        List<OrderMaster> all = orderMasterDao.findAll();

        System.out.println("result：" + all.toArray());
    }

}