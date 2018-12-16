package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Product;
import com.github.pagehelper.PageInfo;

/**
 * 商品管理Service
 * @author zyz
 * @version 2018-12-16
 */
public interface ProductService {

	Product get(String id);

    Product get(Product product);

    List<Product> findList(Product product);

    PageInfo<Product> findPage(Product product);

    void save(Product product);

    void delete(Product product);
		
}