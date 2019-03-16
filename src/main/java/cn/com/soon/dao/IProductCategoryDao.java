package cn.com.soon.dao;

import cn.com.soon.model.ProductCategory;

import java.util.List;

public interface IProductCategoryDao {
    int deleteByPrimaryKey(Integer categoryId);

    void insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}