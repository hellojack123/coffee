package com.lzekai.coffee.service;

import com.lzekai.coffee.domain.TbOrder;
import com.lzekai.coffee.domain.TbOrderItem;

import java.util.List;

public interface TbOrderItemService {

    /**
     * 插入
     * @param tbOrderItem
     * @return
     */
    int insert(TbOrderItem tbOrderItem);

    /**
     * 通过OrderId获取列表
     * @param orderId
     * @return
     */
    List<TbOrderItem> listByOrderId(Long orderId);


}
