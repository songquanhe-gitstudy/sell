package cn.com.soon.Dao;

import cn.com.soon.dao.ISellerInfoDao;
import cn.com.soon.model.SellerInfo;
import cn.com.soon.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private ISellerInfoDao sellerInfoDao;
    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("yugege");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("23455");
        sellerInfoDao.insert(sellerInfo);
//        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = sellerInfoDao.findSellerInfoByOpenid("abc");

        System.out.println(result.toString());
        Assert.assertEquals("abc", result.getOpenid());
    }

}