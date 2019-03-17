package cn.com.soon.dao;

import cn.com.soon.model.OrderMaster;

import java.util.List;

public interface IOrderMasterDao extends IBaseDao{
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);


    List<OrderMaster> findAllByBuyerOpenid(String opendId);

    List<OrderMaster> findAll();
}