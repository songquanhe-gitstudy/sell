package cn.com.soon.service.impl;

import cn.com.soon.dao.IProductCategoryDao;
import cn.com.soon.model.ProductCategory;
import cn.com.soon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private IProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory productCategory = productCategoryDao.selectByPrimaryKey(categoryId);
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryDao.insert(productCategory);
    }
}
