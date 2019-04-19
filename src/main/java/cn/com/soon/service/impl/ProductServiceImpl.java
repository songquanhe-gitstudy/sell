package cn.com.soon.service.impl;

import cn.com.soon.dao.IProductInfoDao;
import cn.com.soon.dto.CartDTO;
import cn.com.soon.enums.ProductStatusEnum;
import cn.com.soon.enums.ResultEnum;
import cn.com.soon.exception.SellException;
import cn.com.soon.model.ProductInfo;
import cn.com.soon.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 */

@Component
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.selectByPrimaryKey(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public PageInfo<ProductInfo> findAll(Integer page, Integer size) {
        page = page == null ? 1 : page;
        size = size == null ? 10 : size;
        PageHelper.startPage(page, size);
        List<ProductInfo> productInfoDaoList = productInfoDao.findAll();
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(productInfoDaoList);
        return pageInfo;
    }

    @Override
    public void save(ProductInfo productInfo) {
        productInfoDao.insert(productInfo);
    }

    @Override
    public void updateByKey(ProductInfo productInfo) {
        productInfoDao.updateByPrimaryKey(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.selectByPrimaryKey(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            productInfoDao.updateByPrimaryKey(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.selectByPrimaryKey(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            productInfoDao.insert(productInfo);
        }
    }

    @Override
    public void onSale(String productId) {
        ProductInfo productInfo = productInfoDao.selectByPrimaryKey(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoDao.updateByPrimaryKey(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.selectByPrimaryKey(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfoDao.updateByPrimaryKey(productInfo);

        return productInfoDao.selectByPrimaryKey(productId);
    }
}
