package com.lzekai.coffee.entity;

import com.lzekai.coffee.domain.TbItem;

public class ItemEntity extends TbItem {
    private Long parentItemId;


    public Long getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Long parentItemId) {
        this.parentItemId = parentItemId;
    }
}
