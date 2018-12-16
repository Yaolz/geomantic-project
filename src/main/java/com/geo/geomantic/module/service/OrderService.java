package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Order;
import com.github.pagehelper.PageInfo;

/**
 * 订单管理Service
 * @author zyz
 * @version 2018-12-16
 */
public interface OrderService {

	Order get(String id);

    Order get(Order order);

    List<Order> findList(Order order);

    PageInfo<Order> findPage(Order order);

    void save(Order order);

    void delete(Order order);
		
}