package cn.com.soon.service.impl;

import cn.com.soon.dao.ISellerInfoDao;
import cn.com.soon.model.SellerInfo;
import cn.com.soon.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卖家端
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private ISellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findSellerInfoByOpenid(openid);
    }
}
