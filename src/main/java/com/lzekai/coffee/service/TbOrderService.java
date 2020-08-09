package com.lzekai.coffee.service;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbOrder;
import com.lzekai.coffee.entity.ItemEntity;
import com.lzekai.coffee.entity.OrderEntity;

import java.util.List;

public interface TbOrderService {

    /**
     * 插入订单
     * @param data
     */
    TbOrder insertList(List<ItemEntity> data);

    /**
     * 插入
     * @param tbOrder
     * @return
     */
    int insert(TbOrder tbOrder);

    /**
     * 获取订单状态
     * @param id
     * @return
     */
    int getStateById(Long id);

    /**
     * 获取订单
     * @param id
     * @return
     */
    OrderEntity getOrderEntityById(Long id);

    /**
     * 更新
     * @param tbOrder
     * @return
     */
    int update(TbOrder tbOrder);

    TbOrder getById(Long id);
}
