package cn.com.soon.dao;

import cn.com.soon.model.ProductInfo;

import java.util.List;

public interface IProductInfoDao extends IBaseDao{
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    List<ProductInfo> findByProductStatus(Integer status);

    List<ProductInfo> findAll();

}