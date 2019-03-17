package cn.com.soon.dao;

import cn.com.soon.model.OrderDetail;

import java.util.List;

public interface IOrderDetailDao {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> findAllByOrderId(String orderId);

}