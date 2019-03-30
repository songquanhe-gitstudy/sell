package cn.com.soon.service;

import cn.com.soon.model.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    void save(ProductCategory productCategory);

    void updateByKey(ProductCategory productCategory);
}
