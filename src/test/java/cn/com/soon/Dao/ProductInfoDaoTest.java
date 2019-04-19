package cn.com.soon.Dao;

import cn.com.soon.dao.IProductInfoDao;
import cn.com.soon.model.ProductInfo;
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
public class ProductInfoDaoTest {

    @Autowired
    private IProductInfoDao productInfoDao;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("皮蛋粥8");
        productInfo.setProductPrice(new BigDecimal(8.2));
        productInfo.setProductStock(800);
        productInfo.setProductDescription("很好喝的粥3");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);

        productInfoDao.insert(productInfo);
//        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(0);
        System.out.println("list：" + productInfoList.size());
        Assert.assertNotEquals(0, productInfoList.size());
    }

}