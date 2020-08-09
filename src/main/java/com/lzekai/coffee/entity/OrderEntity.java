package com.lzekai.coffee.entity;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbOrder;
import com.lzekai.coffee.domain.TbOrderItem;

import java.util.List;

public class OrderEntity extends TbOrder {
    List<TbOrderItem> items;

    public List<TbOrderItem> getItems() {
        return items;
    }

    public void setItems(List<TbOrderItem> items) {
        this.items = items;
    }
}
