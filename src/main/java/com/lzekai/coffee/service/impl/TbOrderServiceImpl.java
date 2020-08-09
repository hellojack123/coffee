package com.lzekai.coffee.service.impl;

import java.util.ArrayList;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbOrder;
import com.lzekai.coffee.domain.TbOrderItem;
import com.lzekai.coffee.entity.ItemEntity;
import com.lzekai.coffee.entity.OrderEntity;
import com.lzekai.coffee.mapper.TbOrderMapper;
import com.lzekai.coffee.service.TbItemService;
import com.lzekai.coffee.service.TbOrderItemService;
import com.lzekai.coffee.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;
    @Autowired
    private TbOrderItemService tbOrderItemService;
    @Autowired
    private TbItemService tbItemService;

    @Override
    public TbOrder insertList(List<ItemEntity> data) {
        double price = 0;
        for (TbItem item : data) {
            price += Double.parseDouble(item.getUnitPrice());
        }

        TbOrder order = new TbOrder();
        order.setPrice(String.valueOf(price));
        order.setCreated(new Date());
        order.setPayState(0);
        this.insert(order);

        for (ItemEntity item : data) {
            TbOrderItem orderItem = new TbOrderItem();
            orderItem.setItemId(item.getId());
            orderItem.setOrderId(order.getId());
            orderItem.setUnitPrice(item.getUnitPrice());
            if (item.getIngredients()) {
                orderItem.setName(tbItemService.getById(item.getParentItemId()).getName() + "+" + item.getName());
                orderItem.setIngredients(true);
            } else {
                orderItem.setName(item.getName());
                orderItem.setIngredients(false);
            }
            tbOrderItemService.insert(orderItem);
        }

        return order;
    }

    @Override
    public int insert(TbOrder tbOrder) {
        return tbOrderMapper.insert(tbOrder);
    }

    @Override
    public int getStateById(Long id) {
        TbOrder tbOrder = getById(id);
        return tbOrder.getPayState();
    }

    @Override
    public OrderEntity getOrderEntityById(Long id) {
        TbOrder tbOrder = getById(id);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(tbOrder.getId());
        orderEntity.setPrice(tbOrder.getPrice());
        orderEntity.setCreated(tbOrder.getCreated());
        orderEntity.setPayState(tbOrder.getPayState());
        List<TbOrderItem> orderItems = tbOrderItemService.listByOrderId(tbOrder.getId());
        orderEntity.setItems(orderItems);
        return orderEntity;
    }

    @Override
    public int update(TbOrder tbOrder) {
        return tbOrderMapper.updateByPrimaryKey(tbOrder);
    }

    @Override
    public TbOrder getById(Long id) {
        return tbOrderMapper.selectByPrimaryKey(id);
    }
}
