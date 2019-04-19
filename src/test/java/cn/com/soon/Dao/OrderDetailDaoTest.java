package cn.com.soon.Dao;

import cn.com.soon.dao.IOrderDetailDao;
import cn.com.soon.model.OrderDetail;
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
public class OrderDetailDaoTest {

    @Autowired
    private IOrderDetailDao orderDetailDao;


    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567817");
        orderDetail.setOrderId("11111117");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("11111117");
        orderDetail.setProductName("南瓜粥7");
        orderDetail.setProductPrice(new BigDecimal(7.2));
        orderDetail.setProductQuantity(70);

        int insert = orderDetailDao.insert(orderDetail);

        Assert.assertNotNull(insert);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailDao.findAllByOrderId("11111112");
        System.out.println("list：" + orderDetailList.size());
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}