package com.lzekai.coffee.service;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbOrderItem;

import java.util.List;

public interface TbItemService {

    /**
     * 查询所有商品
     *
     * @return
     */
    List<TbItem> list();

    /**
     * 插入商品
     * @param tbItem
     * @return
     */
    int insert(TbItem tbItem);

    /**
     * 通过OrderItem获取所有商品
     * @param tbOrderItems
     * @return
     */
    List<TbItem> listByOrderItemList(List<TbOrderItem> tbOrderItems);


    TbItem getById(Long id);

}
